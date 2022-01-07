package com.yieldteam.apteryx.app.ui.shapes;

import java.awt.*;

public class RoundedRect extends Rect {

    private int arcWidth, arcHeight;

    public RoundedRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        super(x, y, width, height);
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
    }

    @Override
    public void shape(Graphics graphics) {
        if (isFill())
            graphics.fillRoundRect((int) getX(), (int) getY(), getWidth(), getHeight(), arcWidth, arcHeight);
        else
            graphics.drawRoundRect((int) getX(), (int) getY(), getWidth(), getHeight(), arcWidth, arcHeight);
    }

    public int getArcWidth() {
        return arcWidth;
    }

    public void setArcWidth(int arcWidth) {
        this.arcWidth = arcWidth;
    }

    public int getArcHeight() {
        return arcHeight;
    }

    public void setArcHeight(int arcHeight) {
        this.arcHeight = arcHeight;
    }
}
