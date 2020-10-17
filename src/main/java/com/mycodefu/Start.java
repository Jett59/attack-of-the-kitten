package com.mycodefu;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.mycodefu.animation.GameLoopAnimation;
import com.mycodefu.game.GameListener;
import com.mycodefu.game.GameObject;
import com.mycodefu.game.floor.FloorGameObject;
import com.mycodefu.game.health.HealthGameObject;
import com.mycodefu.game.lasor.LasorGameObject;
import com.mycodefu.game.over.GameOverGameObject;
import com.mycodefu.game.player.PlayerGameObject;
import com.mycodefu.game.timer.TimerGameObject;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Start extends Application {
	public static double screenWidth = 1024, screenHeight = 768;
	private static GameObject[] objects = new GameObject[] {
			new PlayerGameObject(),
			new TimerGameObject(),
			new FloorGameObject(),
			new HealthGameObject(),
			new LasorGameObject(),
			new GameOverGameObject()
	};
	private static List<Runnable> listeners = new ArrayList<>();
	private static List<GameListener<GameObject>> gameListeners = new ArrayList<>();
	private static Group nodes = new Group();
public static void main(String[] args) {
	try {
		for(GameObject object : objects) {
			nodes.getChildren().add(object.getView());
			for(String listener : object.getAttachedListenerNames()) {
				@SuppressWarnings({ "unchecked", "static-access", "deprecation" })
				GameListener<GameObject> gameListener = (GameListener<GameObject>) GameListener.class.forName(listener).newInstance();
				gameListener.attachedObject = object;
				gameListeners.add(gameListener);
				listeners.add(gameListener::update);
			}
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
	Start.launch(args);
}
	@Override
	public void start(Stage primaryStage) throws Exception {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		primaryStage.setTitle("Jam");
		primaryStage.show();
		Pane screen = new Pane();
		screen.setScaleX((double)screenSize.width/screenWidth);
		screen.setScaleY((double)screenSize.height/screenHeight);
		screen.setLayoutX(screenWidth/2d);
		screen.setLayoutY(screenHeight/4d);
		Scene scene = new Scene(screen);
		scene.getStylesheets().add("/app.css");
		screen.getStyleClass().add("background");
		screen.getChildren().addAll(nodes.getChildren());
		primaryStage.setScene(scene);
		primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		primaryStage.setFullScreen(true);
		for(GameListener<GameObject> gameListener : gameListeners) {
			gameListener.parent = screen;
			gameListener.attach = this::attach;
			gameListener.initialise();
		}
		GameLoopAnimation gameLoop = new GameLoopAnimation(this::tick, 32);
		gameLoop.play();
	}
private void tick() {
	for(Runnable callback : Start.listeners) {
		callback.run();
	}
}
public <T extends GameObject> void attach(String gameObjectName, GameListener<T> gameListener) {
	for(GameObject gameObject : objects) {
		String name = gameObject.getClass().getSimpleName();
		if(name.equalsIgnoreCase(gameObjectName)) {
			try {
				Field field = gameListener.getClass().getDeclaredField(name.toLowerCase());
				field.set(gameListener, gameObject);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
}
