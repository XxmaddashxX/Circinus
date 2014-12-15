package net.circinus.game.threads;

import net.circinus.game.debug.Out;

import org.lwjgl.Sys;

public class FPSThread implements Runnable{
	private static double fps, lastFPS;
	@Override
	public  void run() {
		Out.print("THREAD_INFO", "Thread [FPSThread] has started");
		boolean isRunning = true;
		lastFPS = getTime();
		while(isRunning){
			updateFPS();
		}
		Out.print("THREAD_INFO", "Thread [FPSThread] has stopped");
	}
	public static void updateFPS() {
	    if (getTime() - lastFPS > 1000) {
	       
	        setFps(0); 
	        lastFPS += 1000; 
	    }
	    setFps(getFps() + 1);
	}
	public static long getTime() {
	    return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	public static double getFps() {
		return fps;
	}
	public static void setFps(double fps) {
		FPSThread.fps = fps;
	}

}
