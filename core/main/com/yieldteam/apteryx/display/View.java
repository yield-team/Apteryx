package com.yieldteam.apteryx.display;

import com.yieldteam.apteryx.app.AppObject;
import com.yieldteam.apteryx.app.ApteryxApplication;
import com.yieldteam.apteryx.objects.Obj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Collection;
import java.util.EventListener;
import java.util.HashSet;

/**
 * Author: Vítor Toledo
 */
public class View extends JFrame implements SceneControl, ComponentListener {

    private final HashSet<GraphicalObj> objects = new HashSet<>();
    private ViewController viewController;
    private String viewName = getClass().getSimpleName();
    private ApteryxApplication application;
    private Color bgColor = new Color(240, 240, 240);
    private boolean resizing = false;

    public View(String viewName, ApteryxApplication application) {
        if (viewName != null)
            this.setViewName(viewName);
        this.application = application;
        viewController = new ViewController(this);
        add(viewController);
        addComponentListener(this);
        startWindow();
    }

    @Override
    public void toScene(String sceneName) {
        Scene scene = null;
        for (Scene scene1 : SCENES) {
            if (scene1.getName().hashCode() == sceneName.hashCode()) {
                if (scene1.getName().equals(sceneName)) {
                    scene = scene1;
                    break;
                }
            }
        }

        objects.clear();
        assert scene != null;
        for (Obj obj : scene.getObjects())
            if (obj instanceof GraphicalObj) {
                objects.add((GraphicalObj) obj);
                obj.onEnter();
            }
    }

    public void startWindow() {
        setSize(application.getConfiguration().getStartWidth(), application.getConfiguration().getStartHeight());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setIconImage(application.getConfiguration().getWindowIcon());
        setTitle(application.getConfiguration().getWindowName());
        setMinimumSize(new Dimension(application.getConfiguration().getMinWidth(), application.getConfiguration().getMinHeight()));
        setMaximumSize(new Dimension(application.getConfiguration().getMaxWidth(), application.getConfiguration().getMaxHeight()));
        if (application.getConfiguration().isStartCentered())
            setLocationRelativeTo(null);
        setVisible(application.getConfiguration().isStartVisible());
    }

    public void addAppObj(AppObject object) {
        object.setSceneControl(this);
        object.setApp(application);
        application.getObjects().add(object);
        objects.add(object);
        object.onCreate();
    }

    @Override
    public void componentResized(ComponentEvent e) {
        resizing = true;
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        resizing = true;
    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    public HashSet<GraphicalObj> getObjects() {
        return objects;
    }

    public ViewController getViewController() {
        return viewController;
    }

    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public ApteryxApplication getApplication() {
        return application;
    }

    public void setApplication(ApteryxApplication application) {
        this.application = application;
    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    public boolean isResizing() {
        return resizing;
    }

    public void setResizing(boolean resizing) {
        this.resizing = resizing;
    }


}
