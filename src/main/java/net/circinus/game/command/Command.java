package net.circinus.game.command;

import java.util.ArrayList;
import java.util.Arrays;

public class Command {


	public static void checkandRunCommand(String command){
		String[] temp = command.split("\\s+");
		ArrayList<String> temp2 = new ArrayList<String>(Arrays.asList(temp));
		if(temp2.get(0).equals("@player")){

		}
		if(temp2.get(0).equals("@object")){

		}
		if(temp2.get(0).equals("@entity")){

		}
		if(temp2.get(0).equals("@display")){
			System.out.println("Yesy");
		}
		if(temp2.get(0).equals("@system")){

		}
		if(temp2.get(0).equals("@item")){

		}
		if(temp2.get(0).equals("@player")){

		}
		if(temp2.get(0).equals("@config")){

		}
		if(temp2.get(0).equals("@debug")){

		}
		if(temp2.get(0).equals("@control")){

		}
		if(temp2.get(0).equals("@help")){

		}
		if(temp2.get(0).equals("@ship")){

		}
		if(temp2.get(0).equals("@universe")){

		}
		if(temp2.get(0).equals("@planet")){

		}
		if(temp2.get(0).equals("@player")){

		}
		if(temp2.get(0).equals("@star")){

		}
		if(temp2.get(0).equals("@moon")){

		}



	}
}
