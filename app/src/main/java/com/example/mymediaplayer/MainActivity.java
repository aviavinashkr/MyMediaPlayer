package com.example.mymediaplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mymediaplayer.RecycleView.RecycleView_Music;
import com.example.mymediaplayer.RecycleView.RecycleView_Video;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMusic = findViewById(R.id.playMusic);
        Button btnVideo = findViewById(R.id.playVideo);

        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recyvleViewMusic = new Intent(MainActivity.this, RecycleView_Music.class);
                startActivity(recyvleViewMusic);
            }
        });

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recyvleViewVideo = new Intent(MainActivity.this, RecycleView_Video.class);
                startActivity(recyvleViewVideo);
            }
        });
    }

}
