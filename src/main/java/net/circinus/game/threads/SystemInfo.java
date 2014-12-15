package net.circinus.game.threads;

import java.util.concurrent.TimeUnit;

import net.circinus.game.debug.Out;

public class SystemInfo implements Runnable {

	private static int memory_Used, max_Memory, free_Memory, total_Memory,
	available_Processors;


	public static void update(){
		int mb = 1024*1024;
		memory_Used = (int) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / mb);
		max_Memory = (int) (Runtime.getRuntime().maxMemory() / mb);
		free_Memory = (int) (Runtime.getRuntime().freeMemory() / mb);
		total_Memory = (int) (Runtime.getRuntime().totalMemory() / mb);
		setAvailable_Processors(Runtime.getRuntime().availableProcessors());
	}


	public static int getMemory_Used() {
		return memory_Used;
	}


	public static void setMemory_Used(int memory_Used) {
		SystemInfo.memory_Used = memory_Used;
	}


	public static int getMax_Memory() {
		return max_Memory;
	}


	public static void setMax_Memory(int max_Memory) {
		SystemInfo.max_Memory = max_Memory;
	}


	public static int getFree_Memory() {
		return free_Memory;
	}


	public static void setFree_Memory(int free_Memory) {
		SystemInfo.free_Memory = free_Memory;
	}


	public static int getTotal_Memory() {
		return total_Memory;
	}


	public static void setTotal_Memory(int total_Memory) {
		SystemInfo.total_Memory = total_Memory;
	}


	@Override
	public void run() {
		Out.print("THREAD_INFO", "Thread [System Info] started");
		boolean isRunning = true;
		while(isRunning){
			update();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		Out.print("INFO_THREAD", "Thread [SystemInfo] Stopped");
	}


	public static int getAvailable_Processors() {
		return available_Processors;
	}


	public static void setAvailable_Processors(int available_Processors) {
		SystemInfo.available_Processors = available_Processors;
	}

}
