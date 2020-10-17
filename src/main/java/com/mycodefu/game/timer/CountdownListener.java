package com.mycodefu.game.timer;

import com.mycodefu.game.GameListener;

public class CountdownListener extends GameListener<TimerGameObject>{
	@Override
	public void update() {
		if(attachedObject.nextTimeOut != Long.MAX_VALUE) {
		attachedObject.text.setText(Double.toString((attachedObject.nextTimeOut-System.currentTimeMillis())/1000d));
		}
	}

	@Override
	public void initialise() {
		attachedObject.nextTimeOut = System.currentTimeMillis()+attachedObject.lifeSpanMillis;
	}

}
