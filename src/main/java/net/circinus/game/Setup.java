package net.circinus.game;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glScaled;
import static org.lwjgl.opengl.GL11.glViewport;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import net.circinus.game.debug.Out;
import net.circinus.game.font.Fonts;
import net.circinus.game.render.Textures;
import net.circinus.game.threads.DebugStamp;
import net.circinus.game.threads.DebugThread;
import net.circinus.game.threads.SystemInfo;
import net.circinus.game.threads.UpdateRefresh;
import net.circinus.game.threads.ZRuntime;
import net.circinus.game.url.NewsGetter;
import net.circinus.game.util.GameCapatabilities;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.ImageIOImageData;

public class Setup {

	public static int locx;
	public static int locy;
	public static double amount;
	public static void doSetup(){
		setupDisplay();
		amount = 1;
		graphics();
		locx = -1;
		locy = -1;

		Main.textures = new Textures();
		Main.fonts = new Fonts();
		Main.caps = new GameCapatabilities();
		new Thread(new DebugStamp()).start();
		new Thread(new SystemInfo()).start();
		new Thread(new ZRuntime()).start();
		new Thread(new DebugThread()).start();
		new Thread(new UpdateRefresh()).start();
		//new Thread(new FPSThread()).start();
		NewsGetter.getNews();
		Out.print("INFO", NewsGetter.news);
		//Serial.checkSerial();
	}
	private static void setupDisplay(){
		Out.print("INFO", "Starting Display Creation");
		try{
			Display.setResizable(true);
			DisplayMode displayMode = null;
			DisplayMode[] modes = Display.getAvailableDisplayModes();

			for (int i = 0; i < modes.length; i++)
			{
				if (modes[i].getWidth() == 800
						&& modes[i].getHeight() == 600
						&& modes[i].isFullscreenCapable())
				{
					displayMode = modes[i];
				}
			}

			/*try {
				Display.setIcon(new ByteBuffer[] {
						new ImageIOImageData().imageToByteBuffer(ImageIO.read(new File("src/main/resources/assets/sahara/textures/Drifitng_Collosus_icon2.png")), false, false, null),
						new ImageIOImageData().imageToByteBuffer(ImageIO.read(new File("src/main/resources/assets/sahara/textures/Drifitng_Collosus_icon.png")), false, false, null)
				});
			} catch (IOException e) {

				e.printStackTrace();
			}*/
			Display.setDisplayMode(displayMode);
			Display.setTitle("Circinus: Into the Stars");
			Display.sync(60);
			Display.setVSyncEnabled(true);
			Display.create();

			Mouse.create();
			Keyboard.create();
			//=new Thread(new KeyListener()).start();

		}
		catch (LWJGLException e1) {

			e1.printStackTrace();
		}
		Out.print("INFO", "Created Display, Mouse, KeyBoard");
		Out.print("INFO", "Display " + Display.getWidth() + "x" + Display.getHeight());
		Out.print("INFO", "Display_Resizeable = " + Display.isResizable());


	}

	public static void setLocation(int x, int y){
		if(x < -1){
			Out.print("MINOR", "Invalid screen location " + x);
			return;
		}
		if(y < -1){
			Out.print("MINOR", "Invalid screen location " + y);
			return;
		}
		Setup.setLocx(x);
		Setup.setLocy(y);
	}
	public static int getLocx() {
		return locx;
	}
	public static void setLocx(int locx) {
		Setup.locx = locx;
	}
	public static int getLocy() {
		return locy;
	}
	public static void setLocy(int locy) {
		Setup.locy = locy;
	}
	public static void update(){
		if(Setup.locy > -1 && Setup.locx > -1){
			Display.setLocation(Setup.getLocx(), Setup.getLocy());
			Setup.locx = -1;
			Setup.locy = -1;
		}
	}
	public static void graphics(){
		glEnable(GL_TEXTURE_2D);
		glClearColor(0,0,0,0);

		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		/*
		//glViewport(0, 0, Display.getWidth(), Display.getHeight());

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);

		glMatrixMode(GL_MODELVIEW);
		 */
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity(); // Resets any previous projection matrices
		glOrtho(0, Display.getWidth() * amount, Display.getHeight() * amount, 0, 1, -1);

		glMatrixMode(GL_MODELVIEW);

	}
	public static void zoom(double amount){
		double centerX = Display.getWidth() / 2;
		double centerY = Display.getHeight() / 2;
		//glTranslated(centerX, centerY, 0);
		Setup.amount = amount + 1;
		graphics();


	}
	public static void addZoom(double num){
		if(Setup.amount + num > 1.5){
			return;
		}
		Setup.amount = amount + num;
		graphics();
	}
	public static void decreaseZoom(double num){
		if(Setup.amount - num < 0.5){
			return;
		}
		Setup.amount = amount - num;
		graphics();
	}
	public static double getAmount() {
		return amount;
	}
	public static void setAmount(double amount) {
		Setup.amount = amount;
	}
	public static void setCognito(boolean b){
		if(b){
			
			//Display.setTitle("Paint");
			try{
				Display.setIcon(new ByteBuffer[] {
						new ImageIOImageData().imageToByteBuffer(ImageIO.read(new File("src/main/res/assets/circinus/textures/incognito_16.png")), false, false, null),
						new ImageIOImageData().imageToByteBuffer(ImageIO.read(new File("src/main/res/assets/circinus/textures/incognito_32.png")), false, false, null)
				});
			} catch (IOException e) {

				e.printStackTrace();
			}
			try {
				Display.create();
			} catch (LWJGLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			graphics();
		}
	}


}
