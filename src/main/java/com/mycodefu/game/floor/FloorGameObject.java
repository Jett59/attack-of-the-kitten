package com.mycodefu.game.floor;

import com.mycodefu.game.GameObject;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class FloorGameObject extends GameObject {
	public Rectangle floor;
public FloorGameObject() {
	floor = new Rectangle();
	floor.getStyleClass().add("floor");
}
	@Override
	public Node getView() {
		return floor;
	}

	@Override
	public String[] getAttachedListenerNames() {
		return new String[] {
				"com.mycodefu.game.floor.FloorPositioner"
		};
	}

}
