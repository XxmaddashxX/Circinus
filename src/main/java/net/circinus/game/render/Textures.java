package net.circinus.game.render;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class Textures {
	//type_filename
	private ArrayList<Texture> textures;
	public int planet_test = 0, button_test = 1, background_test = 2, a = 3, b = 4, c = 5, d = 6;
	public Textures(){
		this.textures = new ArrayList<Texture>();
		this.addTexture("enviroment/planets", "planet_test");
		this.addTexture("testing", "button_test");
		this.addTexture("testing", "background_test");
		this.addTexture("testing", "sun_test");
		this.addTexture("testing", "planet_test");
		this.addTexture("testing", "moon_test");
		this.addTexture("testing", "dropdown_test");
	}
	private void addTexture(String folder, String fileName){
		this.textures.add(TextureHandler.loadTexture(folder, fileName, "PNG"));
	}
	public Texture getTexture(int point){
		return this.textures.get(point);
	}
	

}
