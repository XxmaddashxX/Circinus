package net.circinus.game.universe;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import java.util.ArrayList;

import net.circinus.game.Main;
import net.circinus.game.camera.Camera;
import net.circinus.game.debug.Out;
import net.circinus.game.font.FontHandler;
import net.circinus.game.font.Fonts;
import net.circinus.game.logic.buttons.GeneralButton;
import net.circinus.game.material.MaterialList;
import net.circinus.game.moon.Moon;
import net.circinus.game.planet.Planet;
import net.circinus.game.render.TextureHandler;
import net.circinus.game.render.Textures;
import net.circinus.game.sun.Sun;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.Color;

public class Universe {
	
	private ArrayList<Moon> moons;
	private ArrayList<Planet> planets;
	private ArrayList<Sun> suns;
	private ArrayList<GeneralButton> buttons_map;
	private String menu;
	private int activeobject;
	private Camera camera;
	private String activetype;
	private boolean isRunning;	
	private Textures textures = Main.getCore().getTextures();
	private Fonts fonts = Main.getCore().getFonts();
	public MaterialList materials;
	
	public Universe(){
		Out.print("INFO", "Game Started");
		this.isRunning = true;
		this.materials = new MaterialList();
		Out.print("INFO", "Materials initialized");
		
		
		
		this.camera = new Camera(0, 0 , 0 , 0 );
		this.menu = "screen_map";
		this.activeobject = -1;
		this.activetype = null;
		this.moons = new ArrayList<Moon>();
		this.planets = new ArrayList<Planet>();
		this.setSuns(new ArrayList<Sun>());
		this.buttons_map = new ArrayList<GeneralButton>();
		this.createButtons();

		this.suns.add(new Sun("Ach-Or-Jolsk", 0, 0, 10, textures.getTexture(textures.a)));
		this.planets.add(new Planet("06478 - DCF", 0 , 250, 1, this.suns.get(0), true, textures.getTexture(textures.b)));
		this.moons.add(new Moon("DV - 49", 0, 350, 10, this.planets.get(0), textures.getTexture(textures.c), false));
		for(int i = 0; i < this.planets.size(); i++){
			this.planets.get(i).getData().randomizeData();
		}
	}

	//1AU = 500 pixels
	private void reinitialize(){
		/*glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluOrtho2D(0,Display.getWidth(),Display.getHeight(),0);
		glMatrixMode(GL_MODELVIEW);
		GL11.glViewport(0,0,Display.getWidth(),Display.getHeight());
		*/
	}

	public void gameLoop(){
		while(isRunning){
			input();
			update();
			//GLUpdate();
			render();
		}
	}
	public void input(){
		while(Mouse.next()){
			if(Mouse.getEventButtonState()){
				int MX = Mouse.getX() - (int)this.camera.getCameraX();
				int MY = Display.getHeight() - Mouse.getY() - (int)this.camera.getCameraY();
				//Planets
				for(int i = 0; i < this.planets.size(); i++){
					Planet planet = this.planets.get(i);
					if(MY >= planet.getPlanety() && MY <= planet.getPlanety() + planet.getPlanetTexture().getImageHeight()){
						if(MX >= planet.getPlanetx() && MX <= planet.getPlanetx() + planet.getPlanetTexture().getImageWidth()){
							this.activeobject = i;
							
							this.activetype = "type_planet";

						}
					}
				}
				//Moon

				//Stars

				//Buttons
				for(int i = 0; i < this.buttons_map.size(); i++){
					GeneralButton but = this.buttons_map.get(i);
					if(MY >= but.getButtony() && MY <= but.getButtony() + but.getButtonheight()){
						if(MX >= but.getButtonx() && MX <= but.getButtonx() + but.getButtonwidth()){
							if(but.getButtonDisplayName().equals("Show Orbit Paths")){

							}
						}

					}
				}
				
			}
		}
		//Zoom
		
	    //Keyboard
		while(Keyboard.next()){
			if(Keyboard.getEventKeyState()){
				
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){

			this.camera.moveCamera(0, +5);
			GL11.glTranslated(0, +5, 0);

		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){

			this.camera.moveCamera(0, -5);
			GL11.glTranslated(0, -5, 0);

		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){

			this.camera.moveCamera(5, 0);
			GL11.glTranslated(+5, 0, 0);

		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){

			this.camera.moveCamera(-5, 0);
			GL11.glTranslated(-5, 0, 0);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
			this.camera.setCameraRotation(this.camera.getCameraRotation() - 1);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_E)){
			this.camera.setCameraRotation(this.camera.getCameraRotation() + 1);
		}
		
		



	}
	public void update(){
		for(int i = 0; i < this.moons.size(); i++){
			this.moons.get(i).update();
		}
		for(int i = 0; i < this.planets.size(); i++){
			this.planets.get(i).update();
		}
		if(Display.wasResized()){
			this.reinitialize();
			this.updateButtons();
		}
		glLoadIdentity();
		camera.update();
		
		
	}
	/*public void GLUpdate(){
		GL11.glLoadIdentity();
	    GLU.gluLookAt((float)camera.getCameraX(),(float)camera.getCameraY(),(float)camera.getCameraZoom(),(float)camera.getCameraX() + 800,(float)0,(float)camera.getCameraZoom() + 800,0,1,0);
	    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	    GL11.glEnable(GL11.GL_LIGHTING);
	    GL11.glPushMatrix();
	    GL11.glTranslatef(0,-0.5f,-8);
	   
	    GL11.glPopMatrix();
	    GL11.glDisable(GL11.GL_LIGHTING);
	}*/
	public void render(){
		glClear(GL_COLOR_BUFFER_BIT);
		glClear(GL_DEPTH_BUFFER_BIT);
		if(this.menu.equals("screen_map")){
			for(int i = 0; i < this.planets.size(); i++){
				Planet planet = this.planets.get(i);
				TextureHandler.drawTexture(planet.getPlanetTexture(), (float)planet.getPlanetx(), (float)planet.getPlanety());
			}
			for(int i = 0; i < this.moons.size(); i++){
				Moon moon = this.moons.get(i);
				TextureHandler.drawTexture(moon.getTexture(), (float)moon.getMoonx(), (float)moon.getMoony());
			}
			for(int i = 0; i < this.suns.size(); i++){
				Sun sun = this.suns.get(i);
				TextureHandler.drawTexture(sun.getTexture(), (float)sun.getSunX(), (float)sun.getSunY());
			}
			this.drawMapUI();
			TextureHandler.drawRotatedTexture(textures.getTexture(textures.background_test), 400  - (float)this.camera.getCameraX(), 400 - (float)this.camera.getCameraY(), (float)-this.camera.getCameraRotation());
			if(this.activetype != null){
				if(this.activetype.equals("type_planet")){
					Planet planet = this.planets.get(this.activeobject);
					FontHandler.drawString(fonts.getFont(fonts.font_timesnewroman_18), (Display.getWidth() - 140) - (int)this.camera.getCameraX(), 125 - (int)this.camera.getCameraY(), planet.getDisplayName(), Color.black);
					FontHandler.drawString(fonts.getFont(fonts.font_timesnewroman_10), (Display.getWidth() - 135) - (int)this.camera.getCameraX(), 145 - (int)this.camera.getCameraY(), "(Planet)", Color.black);
					FontHandler.drawString(fonts.getFont(fonts.font_timesnewroman_18), (Display.getWidth() - 140) - (int)this.camera.getCameraX(), 155 - (int)this.camera.getCameraY(), "X: " + (int)planet.getPlanetx() + " Y: " + (int)planet.getPlanety(), Color.black);
				}
			}
			//this.drawOrbits();
		}
		if(this.menu.equals("screen_ship")){

		}
		if(this.menu.equals("screen_manager")){

		}


		Display.update();
	}
	private void drawMapUI(){
		for(int i = 0; i < 4; i++){
			for(int u = 0; u < Display.getHeight() / 64 + 2; u++){
				TextureHandler.drawRotatedTexture(textures.getTexture(textures.background_test), (Display.getWidth()  + 20 - (64 * i)) - (float)this.camera.getCameraX(), (u * 64) - (float)this.camera.getCameraY(), (float)-this.camera.getCameraRotation());
			}
		}
		for(int i = 0; i < Display.getWidth()/ 64 + 1; i++){
			TextureHandler.drawRotatedTexture(textures.getTexture(textures.background_test),(64 * i) - (float)this.camera.getCameraX() , -20 - (float)this.camera.getCameraY(), (float)- this.camera.getCameraRotation());
		}

		for(int i = 0; i < this.buttons_map.size(); i++){
			GeneralButton but = this.buttons_map.get(i);
			TextureHandler.drawRotatedTexture(but.getTexture(), (float)but.getButtonx() - (float)this.camera.getCameraX(), (float)but.getButtony() - (float)this.camera.getCameraY(), -(float)this.camera.getCameraRotation());
			if(but.getButtontext() != null){
				FontHandler.drawString(fonts.getFont(fonts.font_timesnewroman_18), (int)but.getButtonx() + 2, (int)but.getButtony() + 2 , but.getButtontext(), Color.black);
			}
		}
	}
	private void createButtons(){
		this.buttons_map.add(new GeneralButton("Show Orbit Paths", Display.getWidth() - 100, 20, 32, 32, textures.getTexture(textures.button_test)));
		this.buttons_map.add(new GeneralButton("Move to Ship", Display.getWidth() - 50, 20, 32, 32, textures.getTexture(textures.button_test)));
		this.buttons_map.add(new GeneralButton("Manage Ship", Display.getWidth() - 150, 20, 32, 32, textures.getTexture(textures.button_test)));
		this.buttons_map.add(new GeneralButton("Game", 10, 8, 64, 32, textures.getTexture(textures.d)));
		this.buttons_map.get(3).setButtontext("Game");
	}
	public ArrayList<Sun> getSuns() {
		return suns;
	}
	public void setSuns(ArrayList<Sun> suns) {
		this.suns = suns;
	}
	private void updateButtons(){
		this.buttons_map.get(0).setButtonx(Display.getWidth() - 100);
		this.buttons_map.get(1).setButtonx(Display.getWidth() - 50);
		this.buttons_map.get(2).setButtonx(Display.getWidth() - 150);
		
	}


	public MaterialList getMaterials() {
		return materials;
	}


	public void setMaterials(MaterialList materials) {
		this.materials = materials;
	}
	public void drawOrbits(){
		for(int i = 0; i < this.planets.size(); i++){
			Planet planet = this.planets.get(i);
			double orbitRotation = 0;
			for(int o = 0; o < 360; o++){
			    orbitRotation = orbitRotation + 1;
				double tmp1 = Math.cos( orbitRotation ) * planet.getDistancefromstar() + planet.getSun().getSunX();
				double tmp2 = Math.sin( orbitRotation) * planet.getDistancefromstar() + planet.getSun().getSunY();
				GL11.glLineWidth(5);
				GL11.glColor3f(255, 0, 0);
				GL11.glBegin(GL_LINES);
				GL11.glVertex3d((float)tmp1, (float)tmp2, 0);
				GL11.glVertex3d((float)tmp1 + 1, (float)tmp2 - 1, 0);
			}
		}



		GL11.glEnd();
	}

}
