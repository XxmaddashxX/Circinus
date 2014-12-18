package net.circinus.game.command;

import java.util.ArrayList;
import java.util.Arrays;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

import net.circinus.game.Main;
import net.circinus.game.Setup;
import net.circinus.game.debug.Out;

public class Command {


	public static void checkandRunCommand(String command){
		String[] temp = command.split("\\s+");
		ArrayList<String> temp2 = new ArrayList<String>(Arrays.asList(temp));
		if(temp2.get(0).equals("@player")){
			return;
		}
		if(temp2.get(0).equals("@object")){
			return;
		}
		if(temp2.get(0).equals("@entity")){
			return;
		}
		if(temp2.get(0).equals("@display")){
			if(temp2.get(1).equals("setFullscreen")){
				if(temp2.get(2).equals("true")){

					Main.getCore().setFullscreen(true);
					return;
				}
				if(temp2.get(2).equals("false")){

					Main.getCore().setFullscreen(false);
					return;
				}
				return;
			}
			if(temp2.get(1).equals("setScreenLocation")){
				try{
					Setup.setLocation(Integer.parseInt(temp2.get(2)), Integer.parseInt(temp2.get(3)));
				}
				catch(NullPointerException e){

				}

				return;
			}
			Out.print("MINOR", "Command '" + temp2.get(1) + "' is not a known command for @display");
			return;


		}
		if(temp2.get(0).equals("@system")){
			if(temp2.get(1).equals("exit_hard")){
				System.exit(-1);
			}
			return;
		}
		if(temp2.get(0).equals("@item")){
			return;
		}
		if(temp2.get(0).equals("@player")){
			return;
		}
		if(temp2.get(0).equals("@config")){
			return;
		}
		if(temp2.get(0).equals("@debug")){
			if(temp2.get(1).equals("testOutput")){
				if(temp2.get(2).equals("messages")){
					Out.print("DEBUG", "This data is showing due to the command @debug testOutput. The Characters after have no value code wise. 123456789!£$%^&^&*");
					return;
				}
				if(temp2.get(2).equals("errors")){
					Out.printError("DEBUG", "This data is showing due to the command @debug testOutput. The Characters after have no value code wise. 123456789!£$%^&^&*");
					return;
				}
				return;
			}
			return;
		}
		if(temp2.get(0).equals("@control")){
			return;
		}
		if(temp2.get(0).equals("@help")){
			return;
		}
		if(temp2.get(0).equals("@ship")){
			return;
		}
		if(temp2.get(0).equals("@universe")){
			return;
		}
		if(temp2.get(0).equals("@planet")){
			return;
		}
		if(temp2.get(0).equals("@player")){
			return;
		}
		if(temp2.get(0).equals("@star")){
			return;
		}
		if(temp2.get(0).equals("@moon")){
			return;
		}
		if(temp2.get(0).equals("@audio")){
			return;
		}
		if(temp2.get(0).equals("@camera")){
			if(temp2.get(1).equals("setPos")){
				Main.getCore().getUni().getCamera().setPos(Integer.parseInt(temp2.get(2)), Integer.parseInt(temp2.get(3)), Integer.parseInt(temp2.get(4)), Integer.parseInt(temp2.get(5)));
				return;
			}

			return;
		}
		if(temp2.get(0).equals("@dev")){
			if(temp2.get(1).equals("enableDevKit")){
				if(temp2.get(2).equals("true")){

					return;
				}
				if(temp2.get(2).equals("false")){

					return;
				}
				return;
			}

			return;
		}
		Out.print("MINOR", "Command '" + temp2.get(0) + "' is not known");



	}
}
