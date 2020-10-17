package com.mycodefu.game.player;

import com.mycodefu.animation.MovementAnimation;
import com.mycodefu.animation.MovementAnimation.MovementDirection;
import com.mycodefu.game.GameListener;

import javafx.animation.Animation.Status;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;


public class PlayerMotionListener extends GameListener<PlayerGameObject> {
	@Override
	public void update() {
		
	}

	@Override
	public void initialise() {
		MovementAnimation move = new MovementAnimation(attachedObject.getView(), 200, MovementDirection.Left, 1024, 0, Duration.INDEFINITE);
		getStage().addEventHandler(KeyEvent.KEY_PRESSED, evt->{
			switch (evt.getCode()) {
			case RIGHT: {
				if(move.getStatus().equals(Status.RUNNING)) {
					if(!move.getDirection().equals(MovementDirection.Right)) {
						move.stop();
						attachedObject.playOnly(attachedObject.walkRight);
						move.setDirection(MovementDirection.Right);
						move.play();
					}
				}else {
					move.setDirection(MovementDirection.Right);
					attachedObject.playOnly(attachedObject.walkRight);
					move.play();
				}
				break;
			}
			case LEFT: {
				if(move.getStatus().equals(Status.RUNNING)) {
					if(!move.getDirection().equals(MovementDirection.Left)) {
						move.stop();
						attachedObject.playOnly(attachedObject.walkLeft);
						move.setDirection(MovementDirection.Left);
						move.play();
					}
				}else {
					attachedObject.playOnly(attachedObject.walkLeft);
					move.setDirection(MovementDirection.Left);
					move.play();
				}
				break;
			}
			default:
				break;
			}
		});
		getStage().addEventHandler(KeyEvent.KEY_RELEASED, evt->{
			switch (evt.getCode()) {
			case RIGHT: {
				attachedObject.playOnly(attachedObject.idleRight);
				move.stop();
				break;
			}
			case LEFT: {
				attachedObject.playOnly(attachedObject.idleLeft);
				move.stop();
				break;
			}
			default: break;
			}
		});
	}

}
