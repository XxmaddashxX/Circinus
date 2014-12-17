package net.circinus.game.threads;

import net.circinus.game.debug.Out;

import org.lwjgl.input.Keyboard;

public class KeyListener implements Runnable{

	@Override
	public void run() {
		Out.print("THREAD_INFO", "Thread [Key Listener] started");
		boolean isRunning = true;
		while(isRunning){
			while(Keyboard.next()){

				Out.print("INFO_KEY", Keyboard.getKeyName(Keyboard.getEventKey()));

			}
		}
		Out.print("INFO_THREAD", "Thread [KeyListener] Stopped");

	}



}
