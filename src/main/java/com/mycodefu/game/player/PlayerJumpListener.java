package com.mycodefu.game.player;

import com.mycodefu.game.GameListener;

import javafx.animation.Animation.Status;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class PlayerJumpListener extends GameListener<PlayerGameObject>{

	@Override
	public void update() {
		
	}

	@Override
	public void initialise() {
		TranslateTransition jump = new TranslateTransition(Duration.millis(150), attachedObject.getView());
		jump.setAutoReverse(true);
		jump.setInterpolator(Interpolator.EASE_IN);
		jump.setCycleCount(2);
		jump.setByY(-150);
		getStage().addEventHandler(KeyEvent.KEY_PRESSED, evt->{
			if(evt.getCode().equals(KeyCode.SPACE)) {
				if(!jump.getStatus().equals(Status.RUNNING)) {
					jump.play();
				}
			}
		});
	}

}
