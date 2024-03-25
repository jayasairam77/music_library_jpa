/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.song.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.song.service.*;
import com.example.song.model.*;
import java.util.*;

@RestController
public class SongController {
    @Autowired
    public SongJpaService jservice;

    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId) {
        jservice.deleteSong(songId);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable("songId") int songId, @RequestBody Song sobj) {
        return jservice.updateSong(songId, sobj);
    }

    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable("songId") int songId) {
        return jservice.getSongById(songId);
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song sobj) {
        return jservice.addSong(sobj);
    }

    @GetMapping("/songs")
    public ArrayList<Song> getSongs() {
        return jservice.getSongs();
    }

}