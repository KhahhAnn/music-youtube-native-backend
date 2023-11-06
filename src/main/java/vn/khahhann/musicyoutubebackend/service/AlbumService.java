package vn.khahhann.musicyoutubebackend.service;

import org.springframework.stereotype.Service;
import vn.khahhann.musicyoutubebackend.entity.Album;

@Service
public interface AlbumService {
    public Album addNewAlbumIsAlbum(Album album);
    public Album addNewAlbumIsRadio(Album album);

    public void deleteAlbum(int id);
}
