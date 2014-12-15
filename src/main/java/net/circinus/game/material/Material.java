package net.circinus.game.material;

import org.newdawn.slick.opengl.Texture;

public class Material {
	private String displayname;
	private Texture iconTexture;
	private double mass;
	
	public Material(String name, Texture texture, double mass){
		this.displayname = name;
		this.iconTexture = texture;
		this.mass = mass;
		
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public Texture getIconTexture() {
		return iconTexture;
	}

	public void setIconTexture(Texture iconTexture) {
		this.iconTexture = iconTexture;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

}
