/*
 * 
 * You can use the following import statements
 * 
 * import javax.persistence.*;
 * 
 */

// Write your code here
// songId	INTEGER
// songName	TEXT
// lyricist	TEXT
// singer	TEXT
// musicDirector	TEXT
package com.example.song.model;

import javax.persistence.*;

@Entity
@Table(name = "playlist")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "songid")
    private int songId;
    @Column(name = "songname")
    private String songName;
    @Column(name = "lyricist")
    private String lyricist;
    @Column(name = "singer")
    private String singer;
    @Column(name = "musicdirector")
    private String musicDirector;

    public Song() {
    }

    public Song(int songId, String songName, String lyricist, String singer, String musicDirector) {
        this.songId = songId;
        this.songName = songName;
        this.lyricist = lyricist;
        this.singer = singer;
        this.musicDirector = musicDirector;
    }

    public void setsongId(int songId) {
        this.songId = songId;
    }

    public int getsongId() {
        return this.songId;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongName() {
        return this.songName;
    }
    public void setLyricist(String lyricist){
        this.lyricist = lyricist;
    }
    public String getLyricist(){
        return this.lyricist;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
    public String getSinger() {
        return this.singer;
    }

    public void setMusicDirector(String musicDirector) {
        this.musicDirector = musicDirector;
    }

    public String getMusicDirector() {
        return this.musicDirector;
    }
}
