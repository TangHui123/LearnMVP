package com.talkweb.tanghui.learnsample;

public class SingleClass {
    private volatile static SingleClass instance;
    
    public SingleClass() {}
    
    public static SingleClass getInstance() {
        if(instance == null) {
            synchronized (SingleClass.class) {
                if(instance == null)
                    instance = new SingleClass();
            }
        }
        return instance;
    }
    
}
