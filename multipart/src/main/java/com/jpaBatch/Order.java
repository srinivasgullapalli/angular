package com.jpaBatch;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "ORDERING_CURRENCY")
	private String orderingCurrency;

	@Column(name = "TO_CURRENCY")
	private String toCurrency;

	@Column(name = "TIMESTAMP")
	private String timeStamp;
	
	@Column(name = "DEAL_AMOUNT")
	private Integer dealAmount;

	public Order() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderingCurrency() {
		return orderingCurrency;
	}

	public void setOrderingCurrency(String orderingCurrency) {
		this.orderingCurrency = orderingCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(Integer dealAmount) {
		this.dealAmount = dealAmount;
	}

	public Order(int id, String orderingCurrency, String toCurrency, String timeStamp, Integer dealAmount) {
		super();
		this.id = id;
		this.orderingCurrency = orderingCurrency;
		this.toCurrency = toCurrency;
		this.timeStamp = timeStamp;
		this.dealAmount = dealAmount;
	}

}
