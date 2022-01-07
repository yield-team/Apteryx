package com.yieldteam.apteryx.app.ui;

import com.yieldteam.apteryx.app.AppObject;

public class Button extends AppObject implements Clickable {

    private String text = "Button";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
