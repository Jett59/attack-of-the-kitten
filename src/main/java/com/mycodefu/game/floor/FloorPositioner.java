package com.mycodefu.game.floor;

import com.mycodefu.game.GameListener;
import com.mycodefu.game.player.PlayerGameObject;

public class FloorPositioner extends GameListener<FloorGameObject>{
public PlayerGameObject playergameobject;

	@Override
	public void update() {
		
	}

	@Override
	public void initialise() {
		attach("PlayerGameObject");
		double y = playergameobject.getView().getLayoutY()+playergameobject.idleRight.getCurrentShape().getLayoutBounds().getHeight();
		System.out.println(y);
		attachedObject.floor.setTranslateY(y);
		attachedObject.floor.setWidth(2048);
		attachedObject.floor.setHeight(1024);
	}

}
