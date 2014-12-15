package net.circinus.game.font;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class FontHandler {
	
public static TrueTypeFont loadFont(String fontType, int size){
		
		Font awtFont = new Font(fontType, Font.PLAIN, size);
		TrueTypeFont font = new TrueTypeFont(awtFont, false);
		return font;
	}
	public static void drawString(TrueTypeFont font, int x, int y, String text,  Color color){
		font.drawString(x, y, text, color);
	}
	public static void drawInteger(TrueTypeFont font, int x, int y, int text,  Color color){
		String j = Integer.toString(text);
		font.drawString(x, y, j, color);
	}
	

}
