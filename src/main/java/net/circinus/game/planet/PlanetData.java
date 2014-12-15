package net.circinus.game.planet;

import java.util.ArrayList;
import java.util.Random;

import net.circinus.game.Main;
import net.circinus.game.debug.Out;
import net.circinus.game.material.Material;
import net.circinus.game.material.MaterialList;

public class PlanetData {
	private ArrayList<Material> demands;
	private ArrayList<Material> produce;
	private MaterialList list;
	private boolean wantsSlaves, wilingToTrade;
	private Planet planet;
	public PlanetData(Planet planet){
		this.planet = planet;
		this.demands = new ArrayList<Material>();
		this.produce = new ArrayList<Material>();
		this.wantsSlaves = false;
		this.wilingToTrade = false;
		this.list = new MaterialList();
	}
	public ArrayList<Material> getDemands() {
		return demands;
	}
	public void setDemands(ArrayList<Material> demands) {
		this.demands = demands;
	}
	public ArrayList<Material> getProduce() {
		return produce;
	}
	public void setProduce(ArrayList<Material> produce) {
		this.produce = produce;
	}
	public boolean isWantsSlaves() {
		return wantsSlaves;
	}
	public void setWantsSlaves(boolean wantsSlaves) {
		this.wantsSlaves = wantsSlaves;
	}
	public boolean isWilingToTrade() {
		return wilingToTrade;
	}
	public void setWilingToTrade(boolean wilingToTrade) {
		this.wilingToTrade = wilingToTrade;
	}
	public void randomizeData(){
		Random ran = new Random();
		for(int i = 0; i < ran.nextInt(5); i++){
			this.demands.add(list.getMaterial(ran.nextInt(list.getMaterials().size())));
		}
		for(int i = 0; i < ran.nextInt(5); i++){
			this.produce.add(list.getMaterial(ran.nextInt(list.getMaterials().size())));
		}
		int tmp1 = ran.nextInt();
		int tmp2 = ran.nextInt();
		if((tmp1 % 2) == 0){
			this.wantsSlaves = false;
			
		}
		else{
			this.wantsSlaves = true;
		}
		if((tmp2 % 2) == 0){
			this.wilingToTrade = false;
		}
		else{
			this.wilingToTrade = true;
		}
		Out.print("INFO", "Planet [" + this.planet.getDisplayName() + "] data randomized");
		Out.print("INFO", "Demands: ");
		for(int  i = 0; i < this.demands.size(); i++){
			Material mat = this.demands.get(i);
			Out.continousPrint(mat.getDisplayname() + ", ");
		}
		Out.line();
		Out.print("INFO", "Produce: ");
		for(int  i = 0; i < this.produce.size(); i++){
			Material mat = this.produce.get(i);
			Out.continousPrint(mat.getDisplayname() + ", ");
		}
		Out.line();
		Out.print("INFO", "Will Trade: " + this.wilingToTrade);
		Out.print("INFO", "Wants Slaves " + this.wantsSlaves);

	}

}
