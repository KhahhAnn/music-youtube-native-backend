package vn.khahhann.musicyoutubebackend.service;

import org.springframework.stereotype.Service;
import vn.khahhann.musicyoutubebackend.entity.Song;

@Service
public interface SongService {
    public Song addSongToAlbum(String albumName, Song song);
    public void removeSongFromAlbum(int songId);

}
