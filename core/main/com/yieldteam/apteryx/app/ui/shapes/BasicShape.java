package com.yieldteam.apteryx.app.ui.shapes;

import java.awt.*;

public abstract class BasicShape extends Shape {

    private Color color = Color.red;

    public BasicShape(int x, int y, int width, int height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        graphics.setColor(color);
        shape(graphics);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
