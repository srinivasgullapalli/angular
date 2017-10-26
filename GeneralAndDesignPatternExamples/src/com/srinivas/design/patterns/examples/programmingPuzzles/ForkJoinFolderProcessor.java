package com.srinivas.design.patterns.examples.programmingPuzzles;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class ForkJoinFolderProcessor extends RecursiveTask<List<String>> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2758002718967152665L;
	String path;
	String extension;
	
	public ForkJoinFolderProcessor(String inputPath,String extension) {
               this.path=inputPath;
               this.extension=extension;
	}

	@Override
	protected List<String> compute() {
		List<ForkJoinFolderProcessor> tasks = new ArrayList<ForkJoinFolderProcessor>();
		List<String> list = new ArrayList<String>();
		File file = new File(path);
		List<File> files = Arrays.asList(file.listFiles());
		for(File f : files)
		{
			if(f.isDirectory())
			{
				ForkJoinFolderProcessor task = new ForkJoinFolderProcessor(f.getAbsolutePath(), "*");
				task.fork();
				tasks.add(task);
			}
			else
			{
				System.out.println("File is : "+file.getAbsolutePath());
				list.add(file.getAbsolutePath());
			}
			
			if(tasks.size() >= 50)
				 System.out.println("List of tasks are  : "+tasks.size());
			
 		}
		
		addResultsFromTasks(list, tasks);
		return list;
	}
	
	
	public void addResultsFromTasks(List<String> list, List<ForkJoinFolderProcessor> taskList)
	
	{
		for(ForkJoinFolderProcessor item : taskList)
		{
			list.addAll(item.join());
		}
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         ForkJoinFolderProcessor processor = new ForkJoinFolderProcessor("D:\\SAMPLES", "*");
         ForkJoinPool pool = new ForkJoinPool(4);
         pool.execute(processor);
         do
         {
            System.out.printf("******************************************\n");
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
            System.out.printf("******************************************\n");
            try
            {
               TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e)
            {
               e.printStackTrace();
            }
         } while ((!processor.isDone()) );
         pool.shutdown();
	}

}
