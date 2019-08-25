package com.example.mymediaplayer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymediaplayer.PojoFiles.PojoVideo;
import com.example.mymediaplayer.R;

import java.util.ArrayList;

public class AdapterVideo extends RecyclerView.Adapter<AdapterVideo.VideoHolder> {

    ArrayList<PojoVideo>videoArray;
    Context context;


    OnVideoClickListener onVideoClickListener;

    public AdapterVideo(Context context,ArrayList<PojoVideo> videoArray){
        this.context = context;
        this.videoArray = videoArray;
    }

    public interface OnVideoClickListener{
        void onVideoClick(Button b, View view,PojoVideo objVid, int positionVid, String url);
    }

    public void setOnVideoClickListener(OnVideoClickListener onVideoClickListener){
        this.onVideoClickListener = onVideoClickListener;
    }


    @NonNull
    @Override
    public AdapterVideo.VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View videoView = LayoutInflater.from(context).inflate(R.layout.row_video,parent,false);
        return new VideoHolder(videoView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterVideo.VideoHolder holder, final int position) {

        final PojoVideo v = videoArray.get(position);
        VideoHolder.videoName.setText(v.videoNamePojo);
        VideoHolder.videoArtistName.setText(v.videoArtistNamePojo);
        VideoHolder.videoPlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onVideoClickListener != null){
                    onVideoClickListener.onVideoClick(VideoHolder.videoPlayBtn,view,v,position,videoArray.get(position).videoUrl);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return videoArray.size();
    }

    public static class VideoHolder extends RecyclerView.ViewHolder {

        static TextView videoName;
        static TextView videoArtistName;
        static Button videoPlayBtn;

        public VideoHolder(@NonNull View itemView) {
            super(itemView);

            videoName = (TextView) itemView.findViewById(R.id.videoName);
            videoArtistName = (TextView) itemView.findViewById(R.id.artistVideoName);
            videoPlayBtn = (Button) itemView.findViewById(R.id.btnVideo);


        }
    }
}
