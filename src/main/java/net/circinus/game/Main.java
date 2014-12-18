package net.circinus.game;

import net.circinus.game.debug.Debug;
import net.circinus.game.font.Fonts;
import net.circinus.game.render.Textures;
import net.circinus.game.util.GameCapatabilities;

public class Main{
	
	public static GameCapatabilities caps;
	public static GameCore core;
	public static Debug debug;
	public static Textures textures;
	public static Fonts fonts;
	
	public static void main(String[] args0){
		Main m = new Main();
		m.dostuff();
	}
	public static GameCore getCore() {
		return core;
	}
	public static void setCore(GameCore core) {
		Main.core = core;
	}
	public void dostuff(){
		Main.debug = new Debug();
		Main.debug.createGui();
		Setup.doSetup();
		
		core = new GameCore();				
		core.start();

	}
	public static Textures getTextures() {
		return textures;
	}
	public static void setTextures(Textures textures) {
		Main.textures = textures;
	}
	public static Fonts getFonts() {
		return fonts;
	}
	public static void setFonts(Fonts fonts) {
		Main.fonts = fonts;
	}
	

}
