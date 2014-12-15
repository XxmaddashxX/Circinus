package net.circinus.game.material;

import java.util.ArrayList;

public class MaterialList {
	private ArrayList<Material> materials;
	public MaterialList(){
		this.materials = new ArrayList<Material>();
		this.addMaterials();
	}
	public ArrayList<Material> getMaterials() {
		return materials;
	}
	public void setMaterials(ArrayList<Material> materials) {
		this.materials = materials;
	}
	public void addMaterials(){
		this.materials.add(new Material("Wood", null, 100));
		this.materials.add(new Material("Carbon", null, 10));
		this.materials.add(new Material("Cotton", null, 50));
		this.materials.add(new Material("Concrete", null, 36));
		this.materials.add(new Material("H20", null, 10));
		this.materials.add(new Material("Hydrogen", null, 10));
		this.materials.add(new Material("Hydrogen Fuel", null, 5));
		this.materials.add(new Material("Oxygen", null, 10));
		this.materials.add(new Material("Iron", null, 10));
		this.materials.add(new Material("Copper", null, 5));
		this.materials.add(new Material("Gold", null, 1));
		this.materials.add(new Material("Silver", null, 2));
		this.materials.add(new Material("Diamonds", null, 0.1));
		this.materials.add(new Material("Rubies", null, 0.3));
		this.materials.add(new Material("Emeralds", null, 0.6));
		this.materials.add(new Material("Cloth", null, 50));
		this.materials.add(new Material("Steel", null, 20));
		this.materials.add(new Material("Titanium", null, 10));
		this.materials.add(new Material("Uranium", null, 5));
		this.materials.add(new Material("Plutonium", null, 10));
		this.materials.add(new Material("Exotic Goods", null, 15));
		this.materials.add(new Material("Noble Gases", null, 10));
		this.materials.add(new Material("Food", null, 50));
	
	
	
	}
	public Material getMaterial(int point){
		return this.materials.get(point);
	}
	

}
