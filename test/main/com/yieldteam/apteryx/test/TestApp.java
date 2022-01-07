package com.yieldteam.apteryx.test;

import com.yieldteam.apteryx.app.ApplicationConfiguration;
import com.yieldteam.apteryx.app.ApteryxApplication;
import com.yieldteam.apteryx.display.View;

public class TestApp extends ApteryxApplication {

    public static void main(String[] args) {
        ApplicationConfiguration config = new ApplicationConfiguration();
        init(new TestApp(), config);
    }

    @Override
    public void start(View startView) {

    }

}
