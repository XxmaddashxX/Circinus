package net.circinus.game.threads;

import java.util.concurrent.TimeUnit;

import net.circinus.game.debug.Out;

public class DebugStamp implements Runnable{

	@Override
	public void run() {
		Out.print("THREAD_INFO", "Thread [DebugStamp] started");
		boolean isRunning = true;
		while (isRunning){
			System.out.println("//SYSTEM TIME STAMP MESSAGES: " + Out.getMessages());
			System.err.println("//SYSTEM TIME STAMP ERRORS: " + Out.getErrors());
			try {
				TimeUnit.MINUTES.sleep(5);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		Out.print("THREAD_INFO", "Thread [DebugStamp] stopped");
		
	}

}
