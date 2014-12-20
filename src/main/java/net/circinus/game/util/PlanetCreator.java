package net.circinus.game.util;

public class PlanetCreator {
	
	
	public static String createClass(double k){
		if(k >= 30000){
			return "O";
		}
		if(k < 30000 && k >= 10000){
			return "B";
		}
		if(k < 10000 && k >= 7500){
			return "A";
		}
		if(k < 7500 && k >= 6000){
			return "F";
		}
		if(k < 6000 && k >= 5200){
			return "G";
		}
		if(k < 5200 && k >= 3700){
			return "K";
		}
		if(k < 3700 && k >= 2400){
			return "M";
		}
		if(k < 2400 && k >= 1300){
			return "L";
		}
		if(k < 1300 && k >= 500){
			return "T";
		}
		if(k < 500){
			return "Y";
		}
		return "UNKNOWN";
		
	}
	

}
