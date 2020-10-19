package com.mycodefu.game;

import javafx.animation.Transition;

public class GameLoopAnimation extends Transition {
private final Runnable tick;
	public GameLoopAnimation(Runnable tick, int frameRate) {
		super(frameRate);
		this.tick = tick;
	}
	@Override
	protected void interpolate(double frac) {
		tick.run();
	}

}
