package net.circinus.game.command;

public class CommandHelp {
	
	public static void printDisplayHelp(){
		System.out.println("---------------");
		System.out.println("@Display Help");
		System.out.println("");
		System.out.println("setFullscreen");
		System.out.println("    Requires: a true or false value");
		System.out.println("    Description: Sets if the screen should be fullscreen or not. On comaptable PCs Only");
		
	}
	public static void printCameraHelp(){
		System.out.println("---------------");
		System.out.println("");
		System.out.println("@Camera Help");
		System.out.println("setPos");
		System.out.println("     Requires: number for x position, y position, zoom and rotation");
		System.out.println("     Description: Sets the camera position, zoom and rotation");
	}

}
