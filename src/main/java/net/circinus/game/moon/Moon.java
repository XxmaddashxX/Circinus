package net.circinus.game.moon;

import net.circinus.game.planet.Planet;

import org.newdawn.slick.opengl.Texture;

public class Moon {
	private String displayName;
	private float distance;
	private double moonx, moony;
	private double velocity, orbitRotation;
	private Planet planet;
	private boolean direction;
	private Texture texture;
	public Moon(String name, float x, float y, double velocity, Planet planet, Texture texture, boolean reverse){
		this.displayName = name;
		
		this.moonx = x;
		this.moony = y;
		this.orbitRotation = 1;
		this.velocity = velocity / 1000;
		this.planet = planet;
		this.direction = reverse;
		this.setTexture(texture);
		this.distance = (float) (this.moony - this.planet.getPlanety());
	}
	public void update(){
		if(this.direction){
			this.orbitRotation = this.orbitRotation + this.getVelocity();
			this.moonx = Math.cos( this.orbitRotation ) * this.distance + planet.getPlanetx();
			this.moony = Math.sin( this.orbitRotation) * this.distance + planet.getPlanety();
		}
		else{
			this.orbitRotation = this.orbitRotation - this.getVelocity();
			this.moonx = Math.cos( this.orbitRotation ) * this.distance + planet.getPlanetx();
			this.moony = Math.sin( this.orbitRotation) * this.distance + planet.getPlanety();

		}
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public double getMoonx() {
		return moonx;
	}
	public void setMoonx(float moonx) {
		this.moonx = moonx;
	}
	public double getMoony() {
		return moony;
	}
	public void setMoony(float moony) {
		this.moony = moony;
	}
	public double getVelocity() {
		return velocity;
	}
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public double getOrbitRotation() {
		return orbitRotation;
	}
	public void setOrbitRotation(double orbitRotation) {
		this.orbitRotation = orbitRotation;
	}
	public void setMoonx(double moonx) {
		this.moonx = moonx;
	}
	public void setMoony(double moony) {
		this.moony = moony;
	}
	public Texture getTexture() {
		return texture;
	}
	public void setTexture(Texture texture) {
		this.texture = texture;
	}
}
