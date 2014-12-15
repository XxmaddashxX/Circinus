package net.circinus.game.planet;

import net.circinus.game.sun.Sun;

import org.newdawn.slick.opengl.Texture;

public class Planet {
	private float   distancefromstar;
	private double planetx, planety,orbitRotation, planetvelocity;
	private Sun sun;
	private boolean direction;
	private String displayName;
	private PlanetData data;
	private Texture planetTexture;
	public Planet(String name, float x, float y, double velocity, Sun sun, boolean reverse, Texture texture){
		this.planetvelocity = velocity / 1000;
		this.planetx = x;
		this.planety = y;
		this.displayName = name;
		this.orbitRotation =  1;
		this.sun = sun;
		this.distancefromstar = (float) (this.planety - this.sun.getSunY());
		
		this.direction  = reverse;
		this.data = new PlanetData(this);
		this.planetTexture = texture;
	}
	
	public void update(){
		if(this.direction){
			this.orbitRotation = this.orbitRotation + this.planetvelocity;
			this.planetx = Math.cos( this.orbitRotation ) * this.distancefromstar + sun.getSunX();
			this.planety = Math.sin( this.orbitRotation) * this.distancefromstar + sun.getSunY();
		}
		else{
			this.orbitRotation = this.orbitRotation - this.planetvelocity;
			this.planetx = Math.cos( this.orbitRotation ) * this.distancefromstar + sun.getSunX();
			this.planety = Math.sin( this.orbitRotation) * this.distancefromstar + sun.getSunY();

		}
			}

	public double getOrbitRotation() {
		return orbitRotation;
	}

	public void setOrbitRotation(float orbitRotation) {
		this.orbitRotation = orbitRotation;
	}

	public double getPlanetvelocity() {
		return planetvelocity;
	}

	public void setPlanetvelocity(float planetvelocity) {
		this.planetvelocity = planetvelocity;
	}

	public float getDistancefromstar() {
		return distancefromstar;
	}

	public void setDistancefromstar(float distancefromstar) {
		this.distancefromstar = distancefromstar;
	}

	public double getPlanetx() {
		return planetx;
	}

	public void setPlanetx(double planetx) {
		this.planetx = planetx;
	}

	public double getPlanety() {
		return planety;
	}

	public void setPlanety(double planety) {
		this.planety = planety;
	}

	public Sun getSun() {
		return sun;
	}

	public void setSun(Sun sun) {
		this.sun = sun;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public boolean isDirection() {
		return direction;
	}

	public void setDirection(boolean direction) {
		this.direction = direction;
	}

	public PlanetData getData() {
		return data;
	}

	public void setData(PlanetData data) {
		this.data = data;
	}

	public Texture getPlanetTexture() {
		return planetTexture;
	}

	public void setPlanetTexture(Texture planetTexture) {
		this.planetTexture = planetTexture;
	}

	public void setOrbitRotation(double orbitRotation) {
		this.orbitRotation = orbitRotation;
	}

	public void setPlanetvelocity(double planetvelocity) {
		this.planetvelocity = planetvelocity;
	}
	
}
