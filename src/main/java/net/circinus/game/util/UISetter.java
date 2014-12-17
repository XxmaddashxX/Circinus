package net.circinus.game.util;

import java.util.ArrayList;
import java.util.Random;

public class UISetter {
	private static ArrayList<String> serials;
	private static Random rand = new Random();
	public static void setup(){
		serials = new ArrayList<String>();
		
	}
	public static String generateSerial(){
		String temp = "XCF" + rand.nextInt(100000) + 100000;
		for(int i = 0; i < serials.size(); i++){
			while(!temp.equals(serials.get(i))){
				temp = "XCF" + rand.nextInt(100000) + 100000;
			}
		}
		serials.add(temp);
		return temp;
	}

}
