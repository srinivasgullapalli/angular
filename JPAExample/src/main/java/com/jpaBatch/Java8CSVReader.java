package com.jpaBatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8CSVReader {

	public static Function<String, Order> mapToOrder = (line) -> {
		String[] p = line.split(",");
		return new Order(Integer.parseInt(p[0]), p[1], p[2], p[3], Integer.parseInt(p[4]));
	};

	public static void main(String[] args) {
		ForkJoinPool customThreadPool = new ForkJoinPool(50);
		ForkJoinPool customThreadPool2 = new ForkJoinPool(80);
		String fileName = "order.csv";
		List<Order> orders = null;
		JpaDAO dao = new JpaDAO();
		java.util.Date date = new java.util.Date();
		Timestamp timestamp1 = new Timestamp(date.getTime());
		try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
			orders = customThreadPool.submit(() -> lines.parallel().map(mapToOrder).collect(Collectors.toList())).get();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
        final List<Order> orders2=orders;
		customThreadPool2.submit(() -> orders2.forEach(order -> {
			dao.createOrder(order.getId(), order.getOrderingCurrency(), order.getToCurrency(), order.getTimeStamp(),
					order.getDealAmount());
		})).invoke();

		java.util.Date date2 = new java.util.Date();
		Timestamp timestamp2 = new Timestamp(date2.getTime());
		float seconds = Long.valueOf(timestamp2.getTime() - timestamp1.getTime()).floatValue() / 1000;
		System.out.println("Time taken to read file having 1,00,000 records  in seconds is  " + seconds);

	}

}
