/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 */

// Write your code here
package com.example.song.service;

import com.example.song.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import com.example.song.model.*;
import java.util.*;

@Service
public class SongJpaService implements SongRepository {

    @Autowired
    private SongJpaRepository jrepository;

    @Override
    public void deleteSong(int songId) {
        try {

            jrepository.deleteById(songId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song updateSong(int songId, Song sobj) {
        try {
            Song s = jrepository.findById(songId).get();
            if (sobj.getSongName() != null)
                s.setSongName(sobj.getSongName());
            if (sobj.getSinger() != null)
                s.setSinger(sobj.getSinger());
            if (sobj.getMusicDirector() != null)
                s.setMusicDirector(sobj.getMusicDirector());
            jrepository.save(s);
            return s;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song getSongById(int songById) {
        try {

            Song s = jrepository.findById(songById).get();
            return s;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song addSong(Song sobj) {
        try {
            jrepository.save(sobj);
            return sobj;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ArrayList<Song> getSongs() {
        List<Song> songl = jrepository.findAll();
        ArrayList<Song> songs = new ArrayList<>(songl);
        return songs;
    }

}