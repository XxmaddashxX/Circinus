package net.circinus.game.font;

import java.util.ArrayList;

import org.newdawn.slick.TrueTypeFont;

public class Fonts {
	public String TIMESNEWROMAN = "Times New Roman";
	public int font_timesnewroman_12 = 0, font_timesnewroman_18 = 1, font_timesnewroman_8 = 2, font_timesnewroman_10 = 3;
	private ArrayList<TrueTypeFont> fonts;
	public Fonts(){
		this.fonts = new ArrayList<TrueTypeFont>();
		this.addFont(TIMESNEWROMAN, 12);
		this.addFont(TIMESNEWROMAN, 18);
		this.addFont(TIMESNEWROMAN, 8);
		this.addFont(TIMESNEWROMAN, 10);
	}
	public void addFont(String type, int size){
		this.fonts.add(FontHandler.loadFont(type, size));
	}
	public TrueTypeFont getFont(int point){
		return this.fonts.get(point);
	}
	
}
