package net.circinus.game.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Serial {

	public static void checkSerial(){
		ArrayList<String> strings = new ArrayList<String>();
		URL oracle = null;
		try {
			oracle = new URL("https://drive.google.com/drive/u/0/#folders/0B3ZMcou4GFFMbUpsMlAyMEVCUVE/0B3ZMcou4GFFMbThiSmhKcE0xcEk");
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		URLConnection yc = null;
		try {
			yc = oracle.openConnection();
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					yc.getInputStream()));
		} catch (IOException e) {

			e.printStackTrace();
		}
		String inputLine;
		try {
			while ((inputLine = in.readLine()) != null){
				System.out.println(inputLine);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}



}


