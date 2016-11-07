package com.talkweb.tanghui.learnsample;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.talkweb.tanghui.learnsample.view.MyViewGroup;
import com.talkweb.tanghui.learnsample.view.TestAnnotation;

/**
 * author：tanghui on 16/5/22
 */

public class MyViewGroupActivity extends Activity {

    @TestAnnotation("helloAnnotation")
    private String testAnnotation;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewgroup);
        MyViewGroup group = (MyViewGroup) findViewById(R.id.myViewGroup);
        group.scroolMy(-100,-100);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String downLoadUrl = "http://talkwebsz-img.oss-cn-hangzhou.aliyuncs.com/image_7e653ff3-d580-47d3-91b2-9bc91d91c881.jpg";
        String fileName = "test.jpg";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downLoadUrl));
        request.setDestinationInExternalPublicDir("/downlaod/", fileName);
        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);

        Log.d("jjj", "annotation = " + testAnnotation);
        for(int i = 0; i < 5; i++) {
            startNotify(this, "test" + i, "通知....");
        }
    }

    private void startNotify(Context context, String title, String content) {
        if (context == null) {
            return;
        }
        if (content == null) {
            content = "[空]";
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
        mBuilder.setContentTitle(title)                             //设置通知栏标题
                .setContentText(content)                            //设置通知栏显示内容
                .setContentIntent(null)   //设置通知栏点击意图
//                .setNumber(number)                                //设置通知集合的数量
                .setTicker(content)                                 //通知首次出现在通知栏，带上升动画效果的
                .setWhen(System.currentTimeMillis())                //通知产生的时间，会在通知信息里显示，一般是系统获取到的时间
                .setPriority(0)                                     //设置该通知优先级
                .setAutoCancel(true)                                //设置这个标志当用户单击面板就可以让通知将自动取消
                .setOngoing(false)                                  //设置为一个正在进行的通知
                .setDefaults(Notification.DEFAULT_ALL)              //Notification.DEFAULT_ALL  Notification.DEFAULT_SOUND
                .setSmallIcon(R.drawable.ic_launcher);                  //设置通知小ICON

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(title.hashCode(), mBuilder.build());

    }

}
