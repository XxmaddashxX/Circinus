package net.circinus.game.achievement;

import java.util.ArrayList;

public class InitAchieve {
	private ArrayList<Achievement> achievements;
	public InitAchieve(){
		this.achievements = new ArrayList<Achievement>();
		this.create();
	}
	private void create(){
		//Copy what is in the speech marks. "this.achievements.add(new Achievement(" ", " ", null));"
		//Fill in the first speech marks with the name
		//Fill in the second speech marks with the description;
		//Leave the final null, that will be the texture when they are made
		//I will do one as a guidance
		this.achievements.add(new Achievement("Game Starter", "You started the game. Well Done!", null));
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
