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
import net.circinus.game.threads.KeyListener;
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
	private int locx = -1, locy = -1;
	public GameCore(){
		
	}
	public void start(){
		Out.print("INFO", "Game Started");
		
		this.initialize();
		this.setupParameters();
		this.gameloop();
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
		this.setFullscreen(false);
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
		try {
			Display.setFullscreen(isFullscreen);
		} catch (LWJGLException e) {
		
			e.printStackTrace();
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
	public boolean isFullscreen() {
		return isFullscreen;
	}
	public void setFullscreen(boolean isFullscreen) {
		this.isFullscreen = isFullscreen;
	}

	
	

}
