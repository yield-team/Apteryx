package com.yieldteam.apteryx.app;

import com.yieldteam.apteryx.Apteryx;
import com.yieldteam.apteryx.display.View;

import java.util.HashSet;

/**
 * Author: Vítor Toledo
 */
public abstract class ApteryxApplication {

    private ApplicationConfiguration configuration;
    private AppEngine engine;
    private View currentView;
    private final HashSet<View> views = new HashSet<>();
    private final HashSet<AppObject> objects = new HashSet<>();

    public static void init(ApteryxApplication application, ApplicationConfiguration configuration) {
        application.setConfiguration(configuration);
        System.out.println("Starting " + application.getConfiguration().getApplicationName() + " in Apteryx " + Apteryx.ALTERYX_RELEASE_VERSION);
        application.engine = new AppEngine();
        application.engine.setApplication(application);
        System.out.println("Creating the start view...");
        View startView = new View("StartView", application);
        application.views.add(startView);
        application.setCurrentView(startView);
        System.out.println("Start view created!");
        application.load();
        Apteryx.application = application;
        System.out.println(application.getConfiguration().getApplicationName() + " started!");
        application.start(startView);
        startView.startWindow();
        application.engine.start();
    }

    public void load() {

    }

    public void toView(String viewName) {
        View view = null;
        for (View view1 : views) {
            if(view1.getViewName().hashCode() == viewName.hashCode()) {
                if(view1.getViewName().equals(viewName)) {
                    view = view1;
                    break;
                }
            }
        }
        assert view != null;
        view.requestFocus();
        currentView = view;
    }

    public View searchView(String viewName) {
        View view = null;
        for (View view1 : views) {
            if(view1.getViewName().hashCode() == viewName.hashCode()) {
                if(view1.getViewName().equals(viewName)) {
                    view = view1;
                    break;
                }
            }
        }
        return view;
    }

    public abstract void start(View startView);

    public ApplicationConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ApplicationConfiguration configuration) {
        this.configuration = configuration;
    }

    public AppEngine getEngine() {
        return engine;
    }

    public void setEngine(AppEngine engine) {
        this.engine = engine;
    }

    public HashSet<AppObject> getObjects() {
        return objects;
    }

    public View getCurrentView() {
        return currentView;
    }

    public void setCurrentView(View currentView) {
        this.currentView = currentView;
    }

    public HashSet<View> getViews() {
        return views;
    }
}
