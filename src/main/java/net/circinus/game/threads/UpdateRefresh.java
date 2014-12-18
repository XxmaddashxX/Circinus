package net.circinus.game.threads;

import net.circinus.game.Setup;

public class UpdateRefresh implements Runnable{

	@Override
	public void run() {
		boolean isRunning = true;
		while(isRunning){
			Setup.update();

		}

	}




}
