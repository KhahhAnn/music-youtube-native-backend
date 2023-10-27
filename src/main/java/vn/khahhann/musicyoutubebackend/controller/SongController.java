package vn.khahhann.musicyoutubebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.khahhann.musicyoutubebackend.entity.Song;
import vn.khahhann.musicyoutubebackend.service.SongService;

@RestController
@RequestMapping("/api")
public class SongController {
    @Autowired
    private SongService songService;

    @PostMapping("/add-to-my-album")
    public ResponseEntity<Song> addSongToMyAlbum(@RequestBody Song song) {
        Song addSong = this.songService.addSongToAlbum("My Album", song);
        System.out.println("Song: " + addSong);
        return new ResponseEntity<Song>(addSong, HttpStatus.OK);
    }

    @DeleteMapping("/delete-to-album/{songId}")
    public ResponseEntity<String> deleteSongToAlbum(@PathVariable int songId) {
        this.songService.removeSongFromAlbum(songId);
        return ResponseEntity.ok("delete complete");
    }
}
