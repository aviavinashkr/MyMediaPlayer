package com.example.mymediaplayer.PojoFiles;

public class PojoVideo {

    public String videoNamePojo , videoArtistNamePojo , videoUrl;

    public PojoVideo() {
    }

    public PojoVideo(String videoNamePojo, String videoArtistNamePojo, String videoUrl) {
        this.videoNamePojo = videoNamePojo;
        this.videoArtistNamePojo = videoArtistNamePojo;
        this.videoUrl = videoUrl;
    }

    public String getVideoNamePojo() {
        return videoNamePojo;
    }

    public String getVideoArtistNamePojo() {
        return videoArtistNamePojo;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
}
