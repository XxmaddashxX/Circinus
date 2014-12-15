package net.circinus.game.logic.physics;

public class GravityPoint {
	private float pointx, pointy, pointstrength;
	public GravityPoint(float x, float y, float strenght){
		this.pointstrength = strenght;
		this.pointx = x;
		this.pointy = y;
	}
	public float getPointx() {
		return pointx;
	}
	public void setPointx(float pointx) {
		this.pointx = pointx;
	}
	public float getPointy() {
		return pointy;
	}
	public void setPointy(float pointy) {
		this.pointy = pointy;
	}
	public float getPointstrength() {
		return pointstrength;
	}
	public void setPointstrength(float pointstrength) {
		this.pointstrength = pointstrength;
	}
	
}
