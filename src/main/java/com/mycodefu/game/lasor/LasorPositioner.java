package com.mycodefu.game.lasor;

import java.util.Random;

import com.mycodefu.game.GameListener;
import com.mycodefu.game.floor.FloorGameObject;

public class LasorPositioner extends GameListener<LasorGameObject> {
public FloorGameObject floorgameobject;
private Random rand;
private int x = 250;

	@Override
	public void update() {
		attachedObject.lasor.setHeight(floorgameobject.floor.getTranslateY());
		attachedObject.lasor.setX(x+rand.nextInt(3));
		attachedObject.lasor.setY(0);
		if(rand.nextInt(50) == 0) {
			x = rand.nextInt(1000);
		}
	}

	@Override
	public void initialise() {
		attach("floorgameobject");
		rand = new Random();
	}

}
