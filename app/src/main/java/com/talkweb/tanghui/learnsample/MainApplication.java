package com.talkweb.tanghui.learnsample;

import android.app.Application;

import com.alipay.euler.andfix.patch.PatchManager;

public class MainApplication extends Application {

    private static Application mApplication;
    
    private static PatchManager patchManager;
    
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }
    
    public static synchronized Application getApplication() {
        if(mApplication == null) {
            synchronized (MainApplication.class) {
                mApplication = new MainApplication();
            }
        }
        return mApplication;
    }
    
    public void init() {
        patchManager = new PatchManager(this);
        patchManager.init("2.2.2");
        patchManager.loadPatch();

//        Intent patchDownloadIntent = new Intent(this,PatchD)
    }
    
    public static PatchManager getPatchManager() {
        return patchManager;
    }
}
