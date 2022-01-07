package com.yieldteam.apteryx.app.ui.shapes;

import java.awt.*;

public class Circle extends Rect {

    public Circle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void shape(Graphics graphics) {
        if (isFill())
            graphics.fillOval((int) getX(), (int) getY(), getWidth(), getHeight());
        else
            graphics.drawOval((int) getX(), (int) getY(), getWidth(), getHeight());
    }
}
