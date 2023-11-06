package vn.khahhann.musicyoutubebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.khahhann.musicyoutubebackend.entity.Album;
import vn.khahhann.musicyoutubebackend.service.AlbumService;

@RestController
@RequestMapping("/api")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @PostMapping("/add-new-album-is-album")
    public ResponseEntity<Album> addAlbumIsAlbum(@RequestBody Album album) {
        Album addAlbum = this.albumService.addNewAlbumIsAlbum(album);
        return new ResponseEntity<Album>(addAlbum, HttpStatus.CREATED);
    }
    @PostMapping("/add-new-album-is-radio")
    public ResponseEntity<Album> addAlbumIsRadio(@RequestBody Album album) {
        Album addAlbum = this.albumService.addNewAlbumIsRadio(album);
        return new ResponseEntity<Album>(addAlbum, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-album/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        this.albumService.deleteAlbum(id);
        return ResponseEntity.ok("delete complete");
    }
}
