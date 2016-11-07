package com.talkweb.tanghui.learnsample.andfix;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;

import com.talkweb.tanghui.learnsample.MainApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PatchDownLoadIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    
    private long fileLength,downloadLength;
    
    public PatchDownLoadIntentService(String name) {
        super(name);
    }
    
    public PatchDownLoadIntentService() {
        super("PatchDownloadIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent != null) {
            String downloadUrl = intent.getStringExtra("url");
            if(downloadUrl != null) {
                downloadPatch(downloadUrl);
            }
        }
    }
    
    private void downloadPatch(String url) {
        File dir = new File(Environment.getExternalStorageDirectory() + "/shine/patch");
        if(!dir.exists()) {
            dir.mkdir();
        }
        File patchFile = new File(dir,String.valueOf(System.currentTimeMillis()) + ".apatch");
        downloadFile(url,patchFile);
        if(patchFile.exists() && patchFile.length() > 0 && fileLength > 0) {
            try {
                MainApplication.getPatchManager().addPatch(patchFile.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void downloadFile(String downloadUrl, File file) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        InputStream ips = null;
        try {
            URL url = new URL(downloadUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(3000);
            fileLength = Long.valueOf(httpURLConnection.getHeaderField("Content-Length"));
            ips = httpURLConnection.getInputStream();
            int hand = httpURLConnection.getResponseCode();
            if (hand == 200) {
                byte[] buffer = new byte[8192];
                int len = 0;
                while ((len = ips.read(buffer)) != -1) {
                    if (fos != null) {
                        fos.write(buffer, 0, len);
                    }
                    downloadLength = downloadLength + len;
                }
            } else {
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (ips != null) {
                    ips.close();
                }
            } catch (IOException e) {
            }
        }
        
    }
}
