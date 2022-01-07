package com.yieldteam.apteryx.display;

import com.yieldteam.apteryx.app.AppObject;
import com.yieldteam.apteryx.objects.Obj;

import java.util.HashSet;

public interface SceneControl {

    HashSet<Scene> SCENES = new HashSet<>();

    default Scene searchScene(String sceneName) {
        Scene scene = null;
        for (Scene scene1 : SCENES) {
            if(scene1.getObjects().hashCode() == sceneName.hashCode()) {
                if(scene1.getName().equals(sceneName)) {
                    scene = scene1;
                    break;
                }
            }
        }
        return scene;
    }

    void toScene(String sceneName);

    default void addScene(Scene scene) {
        scene.setSceneControl(this);
        SCENES.add(scene);
    }

}
