package net.circinus.game.camera;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import org.lwjgl.opengl.Display;
public class Camera {
	private int width, height;
	private double cameraX, cameraY, cameraRotation, cameraZoom;
	public Camera(double x, double y, double rot, double zoom){
		this.cameraRotation = rot;
		this.cameraX = x;
		this.cameraY = y;
		this.cameraZoom = zoom;
		this.height = Display.getHeight();
		this.width = Display.getWidth();
		this.cameraSetup();
	}
	public double getCameraX() {
		return cameraX;
	}
	public void setCameraX(double cameraX) {
		this.cameraX = cameraX;
	}
	public double getCameraY() {
		return cameraY;
	}
	public void setCameraY(double cameraY) {
		this.cameraY = cameraY;
	}
	public double getCameraRotation() {
		return cameraRotation;
	}
	public void setCameraRotation(double cameraRotation) {
		this.cameraRotation = cameraRotation;
	}
	public double getCameraZoom() {
		return cameraZoom;
	}
	public void setCameraZoom(double cameraZoom) {
		this.cameraZoom = cameraZoom;
	}
	public void moveCamera(double x, double y){
		this.cameraX = this.cameraX + x;
		this.cameraY = this.cameraY + y;
	}
	public void cameraSetup(){
		/*glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(70, width/height, 0.3f, 1000);
		glMatrixMode(GL_MODELVIEW);
		//glEnable(GL_DEPTH_TEST);
		 * */
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
	public void update(){
		glTranslated(this.cameraX, this.cameraY, this.cameraZoom);
		this.height = Display.getHeight();
		this.width = Display.getWidth();
		glRotated(this.cameraRotation, 0, 0, 1);
		
	}
	

}
