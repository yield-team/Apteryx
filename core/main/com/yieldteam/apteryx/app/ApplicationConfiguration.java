package com.yieldteam.apteryx.app;

import com.yieldteam.apteryx.Apteryx;
import com.yieldteam.apteryx.display.View;

import java.awt.*;

/**
 * Author: Vítor Toledo
 */
public class ApplicationConfiguration {

    private boolean mouse = true, keyboard = true, switchToSelectedWindow = true,
            startVisible = true, startCentered = true;
    private String applicationName = "Apterix Application", windowName = applicationName;
    private int startWidth = 1280, startHeight = 720, minWidth = 1280,
            minHeight = 720, maxWidth = 0, maxHeight = 0;
    private Image windowIcon = Apteryx.apteryxLogo.getScaledInstance(32, 32, Image.SCALE_FAST);

    public boolean isMouse() {
        return mouse;
    }

    public void setMouse(boolean mouse) {
        this.mouse = mouse;
    }

    public boolean isKeyboard() {
        return keyboard;
    }

    public void setKeyboard(boolean keyboard) {
        this.keyboard = keyboard;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public int getStartWidth() {
        return startWidth;
    }

    public void setStartWidth(int startWidth) {
        this.startWidth = startWidth;
    }

    public int getStartHeight() {
        return startHeight;
    }

    public void setStartHeight(int startHeight) {
        this.startHeight = startHeight;
    }

    public int getMinWidth() {
        return minWidth;
    }

    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public boolean isSwitchToSelectedWindow() {
        return switchToSelectedWindow;
    }

    public void setSwitchToSelectedWindow(boolean switchToSelectedWindow) {
        this.switchToSelectedWindow = switchToSelectedWindow;
    }

    public String getWindowName() {
        return windowName;
    }

    public void setWindowName(String windowName) {
        this.windowName = windowName;
    }

    public boolean isStartVisible() {
        return startVisible;
    }

    public void setStartVisible(boolean startVisible) {
        this.startVisible = startVisible;
    }

    public Image getWindowIcon() {
        return windowIcon;
    }

    public void setWindowIcon(Image windowIcon) {
        this.windowIcon = windowIcon;
    }

    public boolean isStartCentered() {
        return startCentered;
    }

    public void setStartCentered(boolean startCentered) {
        this.startCentered = startCentered;
    }
}
