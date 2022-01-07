package com.yieldteam.apteryx.app.ui.shapes;

import java.awt.*;

public class Rect extends BasicShape {

    private boolean fill = true;

    public Rect(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void shape(Graphics graphics) {
        if (fill)
            graphics.fillRect((int) getX(), (int) getY(), getWidth(), getHeight());
        else
            graphics.drawRect((int) getX(), (int) getY(), getWidth(), getHeight());
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }
}
