package com.yieldteam.apteryx.display;

import com.yieldteam.apteryx.objects.Obj;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Author: Vítor Toledo
 */
public abstract class GraphicalObj implements Obj {

    private boolean visible = true;
    private float angle = 0f, scaleX = 1, scaleY = 1, x, y;
    private int width, height;

    public abstract void draw(Graphics graphics);

    public void processDraw(Graphics2D graphics) {
        if(angle >= 360)
            angle = 0;
        if(angle < 0)
            angle = 0;
        AffineTransform previous = graphics.getTransform();
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToScale(scaleX, scaleY);
        graphics.setTransform(affineTransform);
        graphics.rotate(Math.toRadians(angle * -1), x + width / 2f, y + height / 2f);
        draw(graphics);
        graphics.setTransform(previous);

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getScaleX() {
        return scaleX;
    }

    public void setScaleX(float scaleX) {
        this.scaleX = scaleX;
    }

    public float getScaleY() {
        return scaleY;
    }

    public void setScaleY(float scaleY) {
        this.scaleY = scaleY;
    }
}
