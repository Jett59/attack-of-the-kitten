package com.mycodefu.game.player;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.mycodefu.animation.Animation;
import com.mycodefu.animation.AnimationBuilder;
import com.mycodefu.game.GameObject;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class PlayerGameObject extends GameObject {
public Animation walkRight;
public PlayerGameObject() {
	
}
@Override
public Node getView() {
	return walkRight.getView();
}
@Override
public String[] getAttachedListenerNames() {
	return new String[] {
			
	};
}
@Override
public void initialise() {
	walkRight = new AnimationBuilder().buildAnimation("cat", "Walk", 10, Duration.seconds(1), 100, false);
	walkRight.play();
	try {
		ImageIO.write(SwingFXUtils.fromFXImage(getView().snapshot(new SnapshotParameters(), null), null), "png", new File("player-film-strip.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
