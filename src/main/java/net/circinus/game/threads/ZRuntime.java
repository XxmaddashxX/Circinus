package net.circinus.game.threads;

import java.util.concurrent.TimeUnit;

import net.circinus.game.debug.Out;

public class ZRuntime implements Runnable{

	
	private static int minute;
	private static int second;
	private static int hour;
	
	public ZRuntime(){
		
	}
	
	@Override
	public void run() {
		Out.print("THREAD_INFO", "Thread [ZRuntime] started");
		minute = 0;
		second = 0;
		hour = 0;
		boolean running = true;
		while(running){
			second = second + 1;
			if(second == 60){
				second = 0;
				minute = minute + 1;
				if(minute == 60){
					hour = hour + 1;
				}
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		Out.print("INFO_THREAD", "Thread [ZRuntime] Stopped");
		
	}
	
	public static String getRuntime(){
		String tmp1 = ":0";
		String tmp2 = ":0";
		String tmp3 = "0";
		if(minute > 9){
			tmp1 = ":";
		}
		if(second > 9){
			tmp2 = ":";
		}
		if(hour > 9){
			tmp3 = "";
		}
		return tmp3 + hour + tmp1 + minute + tmp2 + second; 
		
	
	}

}
