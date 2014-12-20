package net.circinus.game.planet;

import net.circinus.game.util.PlanetCreator;

public class PlanetEnviroment {
	private double kelvin;
	private String planetClass;
	public PlanetEnviroment(double k){
		this.kelvin = k;
		this.planetClass = PlanetCreator.createClass(kelvin);
	}

}
