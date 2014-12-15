package net.circinus.game.achievement;

import org.newdawn.slick.opengl.Texture;

public class Achievement {
	private String displayName, displayDescription;
	private Texture icon;
	public Achievement(String name, String description, Texture texture){
		this.displayDescription = description;
		this.displayName = name;
		this.icon = texture;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getDisplayDescription() {
		return displayDescription;
	}
	public void setDisplayDescription(String displayDescription) {
		this.displayDescription = displayDescription;
	}
	public Texture getIcon() {
		return icon;
	}
	public void setIcon(Texture icon) {
		this.icon = icon;
	}

}
