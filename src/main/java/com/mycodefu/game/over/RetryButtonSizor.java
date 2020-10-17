package com.mycodefu.game.over;

import com.mycodefu.game.GameListener;

public class RetryButtonSizor extends GameListener<GameOverGameObject> {

	@Override
	public void update() {
		
	}

	@Override
	public void initialise() {
		attachedObject.gameOverButton.setPrefWidth(attachedObject.gameOverText.getLayoutBounds().getWidth());
	}

}
