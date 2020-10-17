package com.mycodefu.game.health;

import com.mycodefu.game.GameObject;

import javafx.scene.Node;
import javafx.scene.control.ProgressBar;

public class HealthGameObject extends GameObject {
	public ProgressBar healthBar;
public HealthGameObject() {
	healthBar = new ProgressBar(1);
	healthBar.getStyleClass().add("healthBar");
}
	@Override
	public Node getView() {
		return healthBar;
	}

	@Override
	public String[] getAttachedListenerNames() {
		return new String[] {
				"com.mycodefu.game.health.HealthBarPositioner"
		};
	}

}
