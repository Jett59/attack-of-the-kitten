package com.mycodefu.game.over;

import com.mycodefu.game.GameObject;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class GameOverGameObject extends GameObject {
public Text gameOverText;
public Button gameOverButton;
public Pane root;
public GameOverGameObject() {
	gameOverText = new Text("Game Over");
	gameOverText.getStyleClass().add("gameOverText");
	gameOverButton = new Button("retry");
	gameOverButton.getStyleClass().add("retryButton");
	root = new Pane(gameOverText, gameOverButton);
	root.setTranslateX(512-gameOverText.getLayoutBounds().getWidth()/2d);
	root.setTranslateY(150);
	root.setVisible(false);
}

	@Override
	public Node getView() {
		return root;
	}

	@Override
	public String[] getAttachedListenerNames() {
		return new String[] {
				"com.mycodefu.game.over.RetryButtonSizor",
				"com.mycodefu.game.over.RetryListener"
		};
	}

}
