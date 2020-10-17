package com.mycodefu.game.timer;

import com.mycodefu.game.GameObject;

import javafx.scene.Node;
import javafx.scene.text.Text;

public class TimerGameObject extends GameObject {
	public Text text;
	public long nextTimeOut;
	public long lifeSpanMillis = 50000;
public TimerGameObject() {
	text = new Text("loading timer");
	text.getStyleClass().add("timer");
	text.setTranslateX(100);
	text.setTranslateY(250);
}
	@Override
	public Node getView() {
		return text;
	}

	@Override
	public String[] getAttachedListenerNames() {
		return new String[] {
				"com.mycodefu.game.timer.CountdownListener"
		};
	}

}
