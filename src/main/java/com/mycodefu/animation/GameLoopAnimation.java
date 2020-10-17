package com.mycodefu.animation;

import javafx.animation.Transition;
import javafx.util.Duration;

public class GameLoopAnimation extends Transition{
private final Runnable callback;

public GameLoopAnimation(Runnable callback, double fps) {
	super(fps);
	this.callback = callback;
	super.setCycleDuration(Duration.INDEFINITE);
}
	@Override
	protected void interpolate(double frac) {
		callback.run();
	}
	
}
