package com.talkweb.tanghui.learnsample.buildModel;

import android.content.Intent;
import android.net.Uri;

public abstract class Computer {
    protected int mCpuCore = 1;
    protected long mRamSize = 312;
    protected  String mOS = "mac";

    public Computer() {
        super();
        MyData myData = new MyBuilder().setId(2).setNum("22").build();
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(""));
        intent.clone();
    }
}
