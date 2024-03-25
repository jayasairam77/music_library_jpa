// Write your code here
package com.example.song.repository;

import com.example.song.model.*;
import java.util.*;

public interface SongRepository {
    void deleteSong(int songId);

    Song updateSong(int songId, Song sobj);

    Song getSongById(int songById);

    Song addSong(Song sobj);

    ArrayList<Song> getSongs();
}