package com.mycodefu.game.over;

import com.mycodefu.game.GameListener;
import com.mycodefu.game.health.HealthGameObject;
import com.mycodefu.game.timer.TimerGameObject;

public class RetryListener extends GameListener<GameOverGameObject> {
public HealthGameObject healthgameobject;
public TimerGameObject timergameobject;
	
	@Override
	public void update() {
		
	}
	
	@Override
	public void initialise() {
		attach("HealthGameObject");
		attach("TimerGameObject");
		attachedObject.gameOverButton.setOnAction(evt->{
			healthgameobject.healthBar.setProgress(1);
			timergameobject.nextTimeOut = System.currentTimeMillis()+timergameobject.lifeSpanMillis;
			attachedObject.root.setVisible(false);
		});
	}

}
