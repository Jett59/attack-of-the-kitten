package com.mycodefu.game.player;

import com.mycodefu.game.GameListener;
import com.mycodefu.game.health.HealthGameObject;
import com.mycodefu.game.over.GameOverGameObject;
import com.mycodefu.game.timer.TimerGameObject;

public class PlayerDeathListener extends GameListener<PlayerGameObject>{
public TimerGameObject timergameobject;
public HealthGameObject healthgameobject;
public GameOverGameObject gameovergameobject;
private boolean dead;

	@Override
	public void update() {
		if(timergameobject.nextTimeOut <= System.currentTimeMillis()) {
			healthgameobject.healthBar.setProgress(0);
		}
		if(healthgameobject.healthBar.getProgress() <= 0) {
			if(!dead) {
			attachedObject.playOnly(attachedObject.currentAnimation == attachedObject.idleRight || attachedObject.currentAnimation == attachedObject.walkRight ? attachedObject.deadRight : attachedObject.deadLeft);
			}
			attachedObject.deadLeft.setOnFinished(evt->{
				attachedObject.deadLeft.getImageView().setVisible(false);
				dead = true;
			});
			timergameobject.nextTimeOut = Long.MAX_VALUE;
			healthgameobject.healthBar.setVisible(false);
			gameovergameobject.getView().setVisible(true);
		}else {
			healthgameobject.healthBar.setVisible(true);
			dead = false;
		}
	}

	@Override
	public void initialise() {
		attach("TimerGameObject");
		attach("HealthGameObject");
		attach("GameOverGameObject");
	}

}
