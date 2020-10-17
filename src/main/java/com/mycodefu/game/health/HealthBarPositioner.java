package com.mycodefu.game.health;

import com.mycodefu.game.GameListener;
import com.mycodefu.game.player.PlayerGameObject;

public class HealthBarPositioner extends GameListener<HealthGameObject>{
public PlayerGameObject playergameobject;
public double height = 25;

	@Override
	public void update() {
		double x = playergameobject.getView().getTranslateX();
		double y = (playergameobject.getView().getLayoutY()+playergameobject.getView().getTranslateY())-(height+25);
		attachedObject.healthBar.setTranslateX(x);
		attachedObject.healthBar.setTranslateY(y);
	}

	@Override
	public void initialise() {
		attach("PlayerGameObject");
		double width = playergameobject.getView().getLayoutBounds().getWidth();
		double x = playergameobject.getView().getTranslateX();
		double y = playergameobject.getView().getTranslateY();
		attachedObject.healthBar.setTranslateX(x);
		attachedObject.healthBar.setTranslateY(y);
		attachedObject.healthBar.setPrefWidth(width);
		attachedObject.healthBar.setPrefHeight(height);
		System.out.printf("%f, %f", x, y);
	}

}
