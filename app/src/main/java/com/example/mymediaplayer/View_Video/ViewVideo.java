package com.example.mymediaplayer.View_Video;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.mymediaplayer.PojoFiles.PojoVideo;
import com.example.mymediaplayer.R;

public class ViewVideo extends AppCompatActivity {

    VideoView video;

    MediaPlayer videoMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_video);

        PojoVideo pojoVideo = new PojoVideo();

       video = (VideoView) findViewById(R.id.videoView);

        /*videoMediaPlayer = new MediaPlayer();
        videoMediaPlayer.setDataSource(objVid.getVideoUrl());*/

        /*PojoVideo s = new PojoVideo();*/

        Bundle bundle=getIntent().getExtras();
        String path=bundle.getString("UrlOfVid");
        MediaController mc = new MediaController(this);
        mc.setAnchorView(video);
        mc.setMediaPlayer(video);
        Uri uri = Uri.parse(path);
        video.setMediaController(mc);
        video.setVideoURI(uri);

        video.start();

        /*ImageView buttonStart = (ImageView) findViewById(R.id.playBtn);
        buttonStart.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                video.start();
            }*//*

        });*/
    }
}
