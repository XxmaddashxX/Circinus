package net.circinus.game.camera;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;
import net.circinus.game.Setup;

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
		
	}
	public void update(){
		glTranslated(this.cameraX, this.cameraY, this.cameraZoom);
		this.height = Display.getHeight();
		this.width = Display.getWidth();
		glRotated(this.cameraRotation, 0, 0, 1);
		
	}
	public void setPos(double x, double y, double z, double rotation){
		this.cameraX = x;
		this.cameraY = y;
		this.cameraZoom = z;
		this.cameraRotation = rotation;
		
	}
	public void addZoom(double num){
		Setup.addZoom(num);
	}
	public void decreaseZoom(double num){
		Setup.decreaseZoom(num);
	}
	
	

}
