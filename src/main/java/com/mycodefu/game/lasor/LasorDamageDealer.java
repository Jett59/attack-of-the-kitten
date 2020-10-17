package com.mycodefu.game.lasor;

import com.mycodefu.game.GameListener;
import com.mycodefu.game.health.HealthGameObject;
import com.mycodefu.game.player.PlayerGameObject;
import com.mycodefu.game.timer.TimerGameObject;

public class LasorDamageDealer extends GameListener<LasorGameObject> {
public HealthGameObject healthgameobject;
public PlayerGameObject playergameobject;
public TimerGameObject timergameobject;

	@Override
	public void update() {
		if(playergameobject.getBoundsInParent().intersects(attachedObject.lasor.getBoundsInParent())) {
			healthgameobject.healthBar.setProgress(healthgameobject.healthBar.getProgress()-0.006);
			timergameobject.nextTimeOut+=100;
		}
	}

	@Override
	public void initialise() {
		attach("HealthGameObject");
		attach("PlayerGameObject");
		attach("TimerGameObject");
	}

}
