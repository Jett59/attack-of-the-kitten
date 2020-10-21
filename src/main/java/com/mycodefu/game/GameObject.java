package com.mycodefu.game;

import javafx.scene.Node;

public abstract class GameObject {
public abstract Node getView();
public abstract String[] getAttachedListenerNames();
public abstract void initialise();
}
