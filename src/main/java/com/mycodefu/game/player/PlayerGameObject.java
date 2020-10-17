package com.mycodefu.game.player;

import com.mycodefu.animation.Animation;
import com.mycodefu.animation.AnimationCompiler;
import com.mycodefu.game.GameObject;

import javafx.animation.Animation.Status;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class PlayerGameObject extends GameObject {
	public static double y = 500;
	public static double height = 100;
public Animation idleLeft;
public Animation idleRight;
public Animation walkLeft;
public Animation walkRight;
public Animation deadRight;
public Animation deadLeft;
public Animation currentAnimation;
private Pane animations;

public PlayerGameObject() {
	AnimationCompiler animationCompiler = new AnimationCompiler();
	idleRight = animationCompiler.compileAnimation("cat", "Idle", 10, Duration.seconds(1), false, height, "height");
	idleRight.play();
	idleRight.setCycleCount(-1);
	idleLeft = animationCompiler.compileAnimation("cat", "Idle", 10, Duration.seconds(1), true, height, "height");
	idleLeft.getImageView().setVisible(false);
	idleLeft.setCycleCount(-1);
	walkRight = animationCompiler.compileAnimation("cat", "Walk", 10, Duration.seconds(1), false, height, "height");
	walkRight.getImageView().setVisible(false);
	walkRight.setCycleCount(-1);
	walkLeft = animationCompiler.compileAnimation("cat", "Walk", 10, Duration.seconds(1), true, height, "height");
			walkLeft.getImageView().setVisible(false);
			walkLeft.setCycleCount(-1);
			deadRight = animationCompiler.compileAnimation("cat", "Dead", 10, Duration.seconds(1), false, 100, "height");
			deadRight.getImageView().setVisible(false);
			deadRight.setCycleCount(1);
			deadLeft = animationCompiler.compileAnimation("cat", "Dead", 10, Duration.seconds(1), true, 100, "height");
			deadLeft.getImageView().setVisible(false);
			deadLeft.setCycleCount(1);
	animations = new Pane(idleRight.getImageView(), idleLeft.getImageView(), walkRight.getImageView(), walkLeft.getImageView(), deadRight.getImageView(), deadLeft.getImageView());
	animations.getChildren().addAll(idleRight.getPolygons());
	animations.getChildren().addAll(idleLeft.getPolygons());
	animations.getChildren().addAll(walkRight.getPolygons());
	animations.getChildren().addAll(walkLeft.getPolygons());
	animations.setLayoutX(0);
	animations.setLayoutY(y);
	currentAnimation = idleRight;
}
	@Override
	public Node getView() {
		return animations;
	}

	@Override
	public String[] getAttachedListenerNames() {
		return new String[] {
				"com.mycodefu.game.player.PlayerMotionListener",
				"com.mycodefu.game.player.PlayerJumpListener",
				"com.mycodefu.game.player.PlayerDeathListener"
		};
	}
public void playOnly(Animation animation) {
	if(!animation.equals(idleRight)) {
	idleRight.getImageView().setVisible(false);
	idleRight.stop();
	}
	if(!animation.equals(idleLeft)) {
	idleLeft.getImageView().setVisible(false);
	idleLeft.stop();
	}
	if(!animation.equals(walkRight)) {
	walkRight.getImageView().setVisible(false);
	walkRight.stop();
	}
	if(!animation.equals(walkLeft)) {
	walkLeft.getImageView().setVisible(false);
	walkLeft.stop();
	}
	if(!animation.equals(deadRight)) {
	deadRight.getImageView().setVisible(false);
	deadRight.stop();
	}
	if(!animation.equals(deadLeft)) {
	deadLeft.getImageView().setVisible(false);
	deadLeft.stop();
	}
	animation.getImageView().setVisible(true);
	if(!animation.getStatus().equals(Status.RUNNING)) {
	animation.play();
	System.out.println("playing one animation");
	}
	currentAnimation = animation;
}
public Bounds getBoundsInParent() {
	var shapeBounds = currentAnimation.getCurrentShape().getBoundsInParent();
	var bounds = new BoundingBox(shapeBounds.getMinX()+animations.getTranslateX(), shapeBounds.getMinY()+animations.getTranslateY(), shapeBounds.getWidth(), shapeBounds.getHeight());
	return bounds;
}
}
