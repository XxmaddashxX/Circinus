package net.circinus.game.threads;

import net.circinus.game.debug.Debug;
import net.circinus.game.debug.Out;

public class DebugThread implements Runnable{

	
	public DebugThread(){
		
	}
	
	@Override
	public void run() {
		Out.print("THREAD_INFO", "Thread [Debug Thread] started");
		boolean running = true;
		
		while(running){
			
			Debug.runtime_Field.setText(ZRuntime.getRuntime());
			Debug.memory_Field.setText(SystemInfo.getFree_Memory() + "MB");
			Debug.memory_used.setText(SystemInfo.getMemory_Used() + "MB");
			Debug.process_area.setText(SystemInfo.getAvailable_Processors() + " ");
			//Debug.process_area.setText(FPSThread.getFps() + "");
			
		}
		Out.print("INFO_THREAD", "Thread [Debug Thread] Stopped");
		
	}

}
