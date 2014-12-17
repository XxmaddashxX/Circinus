package net.circinus.game;

import net.circinus.game.command.Command;
import net.circinus.game.debug.Debug;
import net.circinus.game.debug.Out;
import net.circinus.game.physics.AU;
import net.circinus.game.physics.Conversion;
import net.circinus.game.threads.DebugStamp;
import net.circinus.game.threads.DebugThread;
import net.circinus.game.threads.SystemInfo;
import net.circinus.game.threads.ZRuntime;
import net.circinus.game.url.NewsGetter;

public class Main{
	
	
	public static GameCore core;
	public static Debug debug;
	public static void main(String[] args0){
		Main m = new Main();
		m.dostuff();
	}
	public static GameCore getCore() {
		return core;
	}
	public static void setCore(GameCore core) {
		Main.core = core;
	}
	public void dostuff(){
		
		Main.debug = new Debug();
		Main.debug.createGui();
		
		new Thread(new DebugStamp()).start();
		new Thread(new SystemInfo()).start();
		new Thread(new ZRuntime()).start();
		new Thread(new DebugThread()).start();
		//new Thread(new FPSThread()).start();
		NewsGetter.getNews();
		Out.print("INFO", NewsGetter.news);
		core = new GameCore();

		core.start();

	}

}
