package net.circinus.game.util;

public class GameCapatabilities {
	
	private static boolean isDemo, isDebugScreenActive, isDevKit;

	public GameCapatabilities(){
		isDemo = false;
		isDebugScreenActive = false;
		isDevKit = false;
	
	}

	public static boolean isDemo() {
		return isDemo;
	}

	public static void setDemo(boolean isDemo) {
		GameCapatabilities.isDemo = isDemo;
	}

	public static boolean isDebugScreenActive() {
		return isDebugScreenActive;
	}

	public static void setDebugScreenActive(boolean isDebugScreenActive) {
		GameCapatabilities.isDebugScreenActive = isDebugScreenActive;
	}

	public static boolean isDevKit() {
		return isDevKit;
	}

	public static void setDevKit(boolean isDevKit) {
		GameCapatabilities.isDevKit = isDevKit;
	}
	
}
