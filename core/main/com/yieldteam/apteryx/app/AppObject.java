package com.yieldteam.apteryx.app;

import com.yieldteam.apteryx.display.GraphicalObj;
import com.yieldteam.apteryx.display.Scene;
import com.yieldteam.apteryx.display.SceneControl;
import com.yieldteam.apteryx.display.View;

import java.awt.*;

/**
 * Author: Vítor Toledo
 */
public abstract class AppObject extends GraphicalObj {

    private ApteryxApplication app;
    private SceneControl sceneControl;

    @Override
    public void draw(Graphics graphics) {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onEnter() {

    }

    @Override
    public void onUpdate(double delta) {

    }

    public final void repaint() {
        for (View view : app.getViews())
            view.repaint();
    }

    public ApteryxApplication getApp() {
        return app;
    }

    public void setApp(ApteryxApplication app) {
        this.app = app;
    }

    public SceneControl getSceneControl() {
        return sceneControl;
    }

    public void setSceneControl(SceneControl sceneControl) {
        this.sceneControl = sceneControl;
    }
}
