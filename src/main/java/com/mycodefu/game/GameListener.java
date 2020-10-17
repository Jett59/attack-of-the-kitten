package com.mycodefu.game;

import java.util.function.BiConsumer;
import javafx.scene.Node;
import javafx.stage.Stage;

public abstract class GameListener<T extends GameObject> {
	public BiConsumer<String, GameListener<T>> attach;
	public T attachedObject;
	public Node parent;
	
public abstract void update();
public abstract void initialise();
public Stage getStage() {
	return (Stage) parent.getScene()
			.getWindow();
}
public void attach(String gameObjectName) {
	attach.accept(gameObjectName, this);
}
@Override
public String toString() {
	return getClass().getSimpleName();
}
}
