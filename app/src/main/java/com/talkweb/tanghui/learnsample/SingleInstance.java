package com.talkweb.tanghui.learnsample;

/**
 * author：tanghui on 16/5/4
 */

public class SingleInstance {
    private static SingleInstance instance;
    
    public static SingleInstance getInstance() {
        if(instance == null) {
            synchronized (SingleInstance.class) {
                if(instance == null) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }
}
