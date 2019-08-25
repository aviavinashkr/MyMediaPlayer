package com.example.mymediaplayer.PojoFiles;

public class PojoMusic {

    public String musicNamePojo , musicArtistNamePojo , musicUrl;

    public PojoMusic() {
    }

    public PojoMusic(String musicNamePojo, String artistNamePojo, String musicUrl) {
        this.musicNamePojo = musicNamePojo;
        this.musicArtistNamePojo = artistNamePojo;
        this.musicUrl = musicUrl;
    }

    public String getMusicNamePojo() {
        return musicNamePojo;
    }


    public String getArtistNamePojo() {
        return musicArtistNamePojo;
    }


    public String getMusicUrl() {
        return musicUrl;
    }

}
