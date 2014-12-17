package net.circinus.game.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NewsGetter {
	
	public static void getNews(){
		 URL oracle = null;
		try {
			oracle = new URL("://github.com/XxmaddashxX/Circinus/blob/master/util/news.txt");
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
				while ((inputLine = in.readLine()) != null) 
				    if(inputLine.contains("variable_news:")){
				    	System.out.println(inputLine);
				    }
				    	
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	        try {
				in.close();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
	}

}
