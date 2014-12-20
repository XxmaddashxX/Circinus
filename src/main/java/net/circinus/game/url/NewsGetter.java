package net.circinus.game.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class NewsGetter {
	public static String news;
	public static void getNews(){
		ArrayList<String> strings = new ArrayList<String>();
		 URL oracle = null;
		try  {
			oracle = new URL("https://github.com/XxmaddashxX/Circinus/blob/master/util/news.txt");
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
				    	
				    	
				    	// <td id="LC1" class="blob-code js-file-line">variable_news:Woop woop</td>
				    	String temp1[] = inputLine.split(":");
				    	
				    	String temp2 = temp1[1];
				    	String temp3[] = temp2.split("<");
				    	strings.add(temp3[0]);
				    }
				    	
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	        try {
				in.close();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
	        news = strings.get(0);
	        for(int i = 1; i < strings.size(); i++){
	        	news = news + " " + strings.get(i);
	        }
	}

}
