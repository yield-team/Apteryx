package com.yieldteam.apteryx.app;

import com.yieldteam.apteryx.display.GraphicalObj;
import com.yieldteam.apteryx.display.View;

public class AppEngine implements Runnable {

    private boolean running = true;
    private Thread thread;
    private ApteryxApplication application;

    @Override
    public void run() {
        long targetTime = 1000 / 60, startTime, endTime = System.nanoTime();
        while (running) {
            startTime = System.nanoTime();
            application.getViews().removeIf(view -> !view.isDisplayable());
            if(application.getViews().size() == 0) {
                setRunning(false);
                break;
            }
            if (application.getConfiguration().isSwitchToSelectedWindow()) {
                for (View view : application.getViews()) {
                    if (view.isActive()) {
                        for (GraphicalObj obj : view.getObjects()) {
                            obj.onUpdate(((startTime - endTime) / 1000000000f));
                        }
                    }
                }
            } else {
                View currentView = application.getCurrentView();
                for (GraphicalObj obj : currentView.getObjects()) {
                    obj.onUpdate(((startTime - endTime) / 1000000000f));
                }
            }
            endTime = System.nanoTime();
            try {
                Thread.sleep(targetTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void forceJoin() throws InterruptedException {
        thread.join();
    }

    public void start() {
        thread = new Thread(this);
        thread.setName("Apteryx AppEngine");
        thread.start();
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public ApteryxApplication getApplication() {
        return application;
    }

    public void setApplication(ApteryxApplication application) {
        this.application = application;
    }
}
