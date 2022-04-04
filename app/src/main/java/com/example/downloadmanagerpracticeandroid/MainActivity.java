package com.example.downloadmanagerpracticeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.webkit.MimeTypeMap;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button download;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        download = findViewById(R.id.download);
        String fileUrl = "https://yts.mx/torrent/download/CC527C79266E7BC49697F1BF7BE8E84AC3709AD0";
        String fileName = "Movie.torrent";

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(fileUrl))
                .setTitle(this.getString(R.string.app_name))
                //it sets extention for app. More extensions Link:
                //androidxref.com/4.4.4_r1/xref/libcore/luni/src/main/java/libcore/net/MimeUtils.java
                .setMimeType("application/x-bittorrent")
                .setDescription("Downloading " + fileName)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE | DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE)
                .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);

        DownloadManager dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        dm.enqueue(request);
    }
}