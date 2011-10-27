package net.slowvic.modal.domain;


/**
 * 歌曲
 */
public class Song {
    /** 曲名 */
    private String name;
    /** 艺术家 */
    private Artist artist;
    /** 时长(秒) */
    private int seconds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String display(String style) {
        return artist.getName() + "正在演奏" + name+",风格为"+style;
    }
    
    public void showTime(){
    	System.out.println("哦一哟");
    }
}
