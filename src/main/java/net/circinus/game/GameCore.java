package net.circinus.game;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glViewport;

import java.util.ArrayList;

import net.circinus.game.debug.Out;
import net.circinus.game.font.Fonts;
import net.circinus.game.logic.buttons.GeneralButton;
import net.circinus.game.render.TextureHandler;
import net.circinus.game.render.Textures;
import net.circinus.game.universe.Universe;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class GameCore {
	private boolean isRunning, isPaused, isFullscreen;
	private ArrayList<GeneralButton> buttons;
	private Fonts fonts;
	private Textures textures;
	private Universe uni;
	public GameCore(){
		
	}
	public void start(){
		Out.print("INFO", "Game Started");
		this.setupDisplay();
		this.initialize();
		this.setupParameters();
		this.gameloop();
	}
	private void setupDisplay(){
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
			
		}
		catch (LWJGLException e1) {
			
			e1.printStackTrace();
		}
		Out.print("INFO", "Created Display, Mouse, KeyBoard");
		Out.print("INFO", "Display " + Display.getWidth() + "x" + Display.getHeight());
		Out.print("INFO", "Display_Resizeable = " + Display.isResizable());
		
		
	}
	private void initialize(){
		
		glEnable(GL_TEXTURE_2D);
		glClearColor(0,0,0,0);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glViewport(0, 0, Display.getWidth(), Display.getHeight());
		glMatrixMode(GL_MODELVIEW);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
	}
	private void setupParameters(){
		this.isFullscreen = false;
		this.isPaused = false;
		this.isRunning = true;
		this.textures = new Textures();
		Out.print("INFO", "Loaded Textures");
		this.fonts = new Fonts();
		Out.print("INFO", "Loaded Fonts");
		this.buttons = new ArrayList<GeneralButton>();
		
	
	}
	private void gameloop(){
		while(isRunning){
			while(!Display.isCloseRequested()){
				while(!isPaused){
					input();
					update();
					render();
				}
			}
			this.isPaused = false;
			this.isRunning = false;
		}
		this.close();
	}
	private void input(){
		while(Mouse.next()){
			
		}
		while(Keyboard.next()){
			if(Keyboard.getEventKey() == Keyboard.KEY_W){
				this.uni = new Universe();
				this.uni.gameLoop();
			}
		}
	}
	public Textures getTextures() {
		return textures;
	}
	public void setTextures(Textures textures) {
		this.textures = textures;
	}
	private void update(){
		if(Display.wasResized()){
			this.initialize();
		}
		if(Display.isCloseRequested()){
			this.isRunning = false;
		}
		
	}
	private void render(){
		glClear(GL_COLOR_BUFFER_BIT);
		glClear(GL_DEPTH_BUFFER_BIT);
		
		
		
		for(int i  = 0; i < this.buttons.size(); i++){
			GeneralButton button = this.buttons.get(i);
			TextureHandler.drawTexture(button.getTexture(), button.getButtonx(), button.getButtony());
		}
		
		Display.update();	
	}
	private void close(){
		Display.destroy();
		Mouse.destroy();
		Keyboard.destroy();
	}
	public Fonts getFonts() {
		return fonts;
	}
	public void setFonts(Fonts fonts) {
		this.fonts = fonts;
	}
	public Universe getUni() {
		return uni;
	}
	public void setUni(Universe uni) {
		this.uni = uni;
	}
	

}