package com.yieldteam.apteryx.objects;

/**
 * Author: Vítor Toledo
 */
public interface Obj {

    default String name() {
        return getClass().getSimpleName();
    }

    void onEnter();

    void onCreate();

    void onUpdate(double elapsed);

}
