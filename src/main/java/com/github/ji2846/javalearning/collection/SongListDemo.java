package com.github.ji2846.javalearning.collection;

import java.io.*;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SongListDemo {
    public static void main(String[] args) {
        File songListFile = new File(SongListDemo.class.getResource("SongList.txt").getFile());
        SongListFileReader reader = new SongListFileReader(songListFile);
        ArrayList<Song> songList = reader.getSongList();
        for (Song s : songList) {
            System.out.println(s);
        }
    }

    public static Logger logger = LogManager.getLogger(SongListDemo.class);
}

class SongListFileReader {
    private ArrayList<Song> songArrayList = new ArrayList<>();
    private File songListFile;

    public SongListFileReader(File songListFile) {
        this.songListFile = songListFile;
    }

    private void readSongList() {
        String aLineData;
        String[] songInfo;
        BufferedReader songListReader;
        if (songListFile.exists() && songListFile.canRead()) {
            try {
                songListReader = new BufferedReader(new FileReader(songListFile));    // 创建SongListReader
                while ((aLineData = songListReader.readLine()) != null) {
                    // 读取文件中的数据，并加入songArrayList中
                    songInfo = aLineData.split(" - ");
                    songArrayList.add(new Song(songInfo[0], songInfo[1]));
                }
            } catch (IOException ioException) {
                SongListDemo.logger.error(ioException);
                ioException.printStackTrace();
            }
        }
    }

    public ArrayList<Song> getSongList() {
        readSongList();
        // 返回从文件中读取出来的歌单
        return songArrayList;
    }
}

class Song {
    private String name;
    private String artist;

    public Song(String songName, String artistName) {
        name = songName;
        artist = artistName;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Song s = (Song) obj;
        return name.equals(s.getName()) && artist.equals(s.getArtist());
    }

    @Override
    public String toString() {
        return name + " - " + artist;
    }
}

