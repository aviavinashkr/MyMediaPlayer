package com.example.mymediaplayer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymediaplayer.PojoFiles.PojoMusic;
import com.example.mymediaplayer.R;

import java.util.ArrayList;

public class AdapterMusic extends RecyclerView.Adapter<AdapterMusic.MusicHolder> {

    ArrayList<PojoMusic> musicArray;
    Context context;

    OnitemClickListener onitemClickListener;

    public AdapterMusic(Context context, ArrayList<PojoMusic> musicArray){
        this.context = context;
        this.musicArray = musicArray;
    }

    public interface OnitemClickListener{
        void onitemClick(Button b ,View view, PojoMusic obj, int position);
    }

    public void setOnitemClickListener(OnitemClickListener onitemClickListener){
        this.onitemClickListener = onitemClickListener;
    }

    @NonNull
    @Override
    public MusicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(context).inflate(R.layout.row_music,parent,false);
        return new MusicHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicHolder holder, final int position) {

        final PojoMusic c = musicArray.get(position);
        MusicHolder.musicName.setText(c.musicNamePojo);
        MusicHolder.artistName.setText(c.musicArtistNamePojo);
        MusicHolder.playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onitemClickListener != null) {
                    onitemClickListener.onitemClick(MusicHolder.playBtn,view, c, position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return musicArray.size();
    }

    public static class MusicHolder extends RecyclerView.ViewHolder {

        static TextView musicName;
        static TextView artistName;
        static Button playBtn;

        public MusicHolder( View itemView) {
            super(itemView);

            musicName = (TextView) itemView.findViewById(R.id.musicName);
            artistName = (TextView) itemView.findViewById(R.id.artistMusicName);
            playBtn = (Button) itemView.findViewById(R.id.btnMusic);

        }
    }
}
