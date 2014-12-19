package net.circinus.game.demo;

import java.util.ArrayList;

import net.circinus.game.Main;
import net.circinus.game.camera.Camera;
import net.circinus.game.moon.Moon;
import net.circinus.game.planet.Planet;
import net.circinus.game.sun.Sun;

public class Demo{
	private Camera camera;
	private ArrayList<Moon> moons;
	private ArrayList<Planet> planets;
	private ArrayList<Sun> stars;
	public Demo(){
		this.moons = new ArrayList<Moon>();
		this.planets = new ArrayList<Planet>();
		this.stars = new ArrayList<Sun>();
	}
	private void setup(){
		this.camera = new Camera(0 , 0 , 0 , 0);
	}
	private void addBodies(){
		this.stars.add(new Sun("SN 1996cr", 0, 0, 0, Main.getTextures().getTexture(Main.getTextures().enviroment_star)));
	}
	private void gameLoop(){
		
	}

}
