package com.talkweb.tanghui.learnsample.buildModel;

/**
 * author：tanghui on 16/6/28
 */

public class MyBuilder {
    
    private int id;
    private String num;
    public MyData build() {
        MyData myData = new MyData();
        myData.setId(id);
        myData.setNum(num);
        return myData;
    }
    
    public MyBuilder setId(int id) {
        this.id = id;
        return this;
    }
    
    public MyBuilder setNum(String num) {
        this.num = num;
        return this;
    }
    
}
