package net.circinus.game.render;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureImpl;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;


public class TextureHandler {


	
	public static Texture loadTexture(String folder, String key, String format){
		try {
			return TextureLoader.getTexture(format.toUpperCase(), ResourceLoader.getResourceAsStream("assets/circinus/textures/" + folder + "/" + key + "." + format.toLowerCase()));
		} catch (IOException e) {

			e.printStackTrace();

		}
		return null;
	}
	public static void drawTexture(Texture texture, float posX, float posY){
		
		if(texture == null){
			return;
		}
		org.newdawn.slick.Color.white.bind();
		TextureImpl.bindNone();
		texture.bind();
		// Draw a textured quad
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0); glVertex2f(posX, posY);
		glTexCoord2f(0, 1); glVertex2f(posX, posY +texture.getTextureHeight());
		glTexCoord2f(1, 1); glVertex2f(posX +texture.getTextureWidth(), posY +texture.getTextureHeight());
		glTexCoord2f(1, 0); glVertex2f(posX + texture.getTextureWidth(), posY);
		glEnd();
		TextureImpl.bindNone();
	}
	public static void drawRotatedTexture(Texture texture, float posx, float posy, float degrees){
		glPushMatrix();
		//glTranslatef(posx,posy, 0); 
		glRotatef(degrees, 0, 0, 1 ); // now rotate

		texture.bind();
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0); glVertex2f(posx, posy);
		glTexCoord2f(0, 1); glVertex2f(posx, posy +texture.getTextureHeight());
		glTexCoord2f(1, 1); glVertex2f(posx +texture.getTextureWidth(), posy +texture.getTextureHeight());
		glTexCoord2f(1, 0); glVertex2f(posx + texture.getTextureWidth(), posy);
		
		glEnd();
		//glTranslatef(-posx,-posy, 0);
		glRotatef(-degrees, 0, 0, 1 );
		
		
	}


}