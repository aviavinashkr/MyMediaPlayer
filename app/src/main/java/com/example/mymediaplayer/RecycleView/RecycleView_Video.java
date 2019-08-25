package com.example.mymediaplayer.RecycleView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mymediaplayer.Adapters.AdapterVideo;
import com.example.mymediaplayer.MainActivity;
import com.example.mymediaplayer.PojoFiles.PojoVideo;
import com.example.mymediaplayer.R;
import com.example.mymediaplayer.View_Video.ViewVideo;

import java.io.IOException;
import java.util.ArrayList;

public class RecycleView_Video extends AppCompatActivity {

    private ArrayList<PojoVideo> videoArray = new ArrayList<PojoVideo>();
    RecyclerView videoRecyclerView;
    AdapterVideo adapterVideo;
    MediaPlayer videoMediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view__video);


        videoRecyclerView = (RecyclerView)findViewById(R.id.recyclerViewVideoId);

        adapterVideo = new AdapterVideo(this,videoArray);

        videoRecyclerView.setAdapter(adapterVideo);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(videoRecyclerView.getContext(),
                linearLayoutManager.getOrientation());
        videoRecyclerView.setLayoutManager(linearLayoutManager);
        videoRecyclerView.addItemDecoration(dividerItemDecoration);


        adapterVideo.setOnVideoClickListener(new AdapterVideo.OnVideoClickListener() {
            @Override
            public void onVideoClick(final Button vb, View view, PojoVideo objVid, int positionVid, String url) {

                Bundle bundle = new Bundle();
                bundle.putString("UrlOfVid", url);
                Intent videoViewLayout = new Intent(getApplicationContext(), ViewVideo.class);
                videoViewLayout.putExtras(bundle);
                startActivity(videoViewLayout);
            }
        });

        checkUserPermission();

    }

    private void checkUserPermission(){
        if(Build.VERSION.SDK_INT>=23){
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},123);
                return;
            }
        }
        loadVideos();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 123:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    loadVideos();
                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                    checkUserPermission();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        }



    }

    private void loadVideos() {
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Video.VideoColumns.DATA + "!=0";
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                    String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                    String url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));

                    PojoVideo s = new PojoVideo(name, artist, url);
                    videoArray.add(s);

                } while (cursor.moveToNext());
            }

            cursor.close();
            adapterVideo = new AdapterVideo(this, videoArray);
        }
    }

}
