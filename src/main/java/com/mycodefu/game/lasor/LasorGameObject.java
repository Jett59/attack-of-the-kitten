package com.mycodefu.game.lasor;

import com.mycodefu.game.GameObject;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class LasorGameObject extends GameObject {
public Rectangle lasor;
public LasorGameObject() {
	lasor = new Rectangle(0, 0, 5, 0);
	lasor.getStyleClass().add("damageLasor");
}
	@Override
	public Node getView() {
		return lasor;
	}

	@Override
	public String[] getAttachedListenerNames() {
		return new String[] {
				"com.mycodefu.game.lasor.LasorPositioner",
				"com.mycodefu.game.lasor.LasorDamageDealer"
		};
	}

}
