package net.circinus.game.sun;

import org.newdawn.slick.opengl.Texture;

public class Sun {
	
	private String displayName;
	private float sunX, sunY, gravityStrength;
	private Texture texture;
	public Sun(String name, float x, float y, float strength, Texture texture){
		this.displayName = name;
		this.sunX = x;
		this.sunY = y;
		this.gravityStrength = strength;
		this.setTexture(texture);
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public float getSunX() {
		return sunX;
	}
	public void setSunX(float sunX) {
		this.sunX = sunX;
	}
	public float getSunY() {
		return sunY;
	}
	public void setSunY(float sunY) {
		this.sunY = sunY;
	}
	public float getGravityStrength() {
		return gravityStrength;
	}
	public void setGravityStrength(float gravityStrength) {
		this.gravityStrength = gravityStrength;
	}
	public Texture getTexture() {
		return texture;
	}
	public void setTexture(Texture texture) {
		this.texture = texture;
	}

}
