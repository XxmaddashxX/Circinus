package net.circinus.game.physics;

public class Conversion {

	public static double AU_to_Pixels(AU au){
		return au.getAu() * 500;
	}
	public static AU Pixels_to_AU(int pixels){
		return new AU(pixels / 500);
	}
	//100000 au = 1.5812281999789 ly
	public static double AU_to_Lighyear(AU au){
		return 1.5812281999789 / (100000 / au.getAu());
	}
	public static AU Lightyear_to_AU(double lightyear){
		return new AU(lightyear * 100000 / 1.5812281999789);
	}
	
}
