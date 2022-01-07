package com.yieldteam.apteryx.display;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Vítor Toledo
 */
public class ViewController extends JPanel {

    private int appWidth, appHeight;
    private View view;
    private boolean antialiasing = true;

    public ViewController(View view) {
        this.view = view;
        view.setViewController(this);
    }

    @Override
    public void update(Graphics g) {
        paintComponent(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        appHeight = getHeight();
        appWidth = getWidth();
        Graphics2D graphics2D = (Graphics2D) g;
        if (antialiasing)
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(view.getBgColor());
        g.fillRect(0, 0, appWidth, appHeight);
        for (GraphicalObj graphicalObj : view.getObjects()) {
            if (graphicalObj.isVisible())
                graphicalObj.processDraw(graphics2D);
        }
        g.dispose();
        if(view.isResizing()) {
            repaint();
            view.setResizing(false);
        }
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public int getAppWidth() {
        return appWidth;
    }

    public void setAppWidth(int appWidth) {
        this.appWidth = appWidth;
    }

    public int getAppHeight() {
        return appHeight;
    }

    public void setAppHeight(int appHeight) {
        this.appHeight = appHeight;
    }

    public boolean isAntialiasing() {
        return antialiasing;
    }

    public void setAntialiasing(boolean antialiasing) {
        this.antialiasing = antialiasing;
    }
}
