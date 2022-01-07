package com.yieldteam.apteryx.display;

import com.yieldteam.apteryx.Apteryx;
import com.yieldteam.apteryx.app.AppObject;
import com.yieldteam.apteryx.objects.Obj;

import java.util.HashSet;

public class Scene {

    private String name = getClass().getSimpleName();
    private SceneControl sceneControl;
    private final HashSet<Obj> objects = new HashSet<>();

    public Scene(String customName) {
        if (customName != null)
            this.name = customName;
    }

    public void addAppObj(AppObject object) {
        object.setSceneControl(sceneControl);
        object.setApp(Apteryx.application);
        objects.add(object);
        object.onCreate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Obj> getObjects() {
        return objects;
    }

    public SceneControl getSceneControl() {
        return sceneControl;
    }

    public void setSceneControl(SceneControl sceneControl) {
        this.sceneControl = sceneControl;
    }
}
