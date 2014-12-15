package net.circinus.game.logic.buttons;

import org.newdawn.slick.opengl.Texture;

public class GeneralButton {
	private boolean isLocked, isHidden;
	private String ButtonDisplayName;
	private int buttonx, buttony, buttonwidth, buttonheight;
	private Texture texture;
	private String buttontext;
	public GeneralButton(String name, int x, int y, int width, int height, Texture texture){
		this.ButtonDisplayName = name;
		this.buttonheight = height;
		this.buttonwidth = width;
		this.buttonx = x; 
		this.buttony = y;
		this.setTexture(texture);
		this.buttontext = null;
	
	}
	public boolean isLocked() {
		return isLocked;
	}
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	public boolean isHidden() {
		return isHidden;
	}
	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}
	public String getButtonDisplayName() {
		return ButtonDisplayName;
	}
	public void setButtonDisplayName(String buttonDisplayName) {
		ButtonDisplayName = buttonDisplayName;
	}
	public int getButtonx() {
		return buttonx;
	}
	public void setButtonx(int buttonx) {
		this.buttonx = buttonx;
	}
	public int getButtony() {
		return buttony;
	}
	public void setButtony(int buttony) {
		this.buttony = buttony;
	}
	public int getButtonwidth() {
		return buttonwidth;
	}
	public void setButtonwidth(int buttonwidth) {
		this.buttonwidth = buttonwidth;
	}
	public int getButtonheight() {
		return buttonheight;
	}
	public void setButtonheight(int buttonheight) {
		this.buttonheight = buttonheight;
	}
	public Texture getTexture() {
		return texture;
	}
	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	public String getButtontext() {
		return buttontext;
	}
	public void setButtontext(String buttontext) {
		this.buttontext = buttontext;
	}
	
}
