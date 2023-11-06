package vn.khahhann.musicyoutubebackend.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.khahhann.musicyoutubebackend.entity.Album;
import vn.khahhann.musicyoutubebackend.repository.AlbumRepository;
import vn.khahhann.musicyoutubebackend.service.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumRepository albumRepository;
    @Override
    public Album addNewAlbumIsAlbum(Album album) {
        if(this.albumRepository.findByAlbumName(album.getAlbumName()) == null) {
            album.setAlbum(true);
            Album newAlbum = this.albumRepository.saveAndFlush(album);
            return newAlbum;
        }
        return null;
    }
    @Override
    public Album addNewAlbumIsRadio(Album album) {
        if(this.albumRepository.findByAlbumName(album.getAlbumName()) == null) {
            album.setRadio(true);
            Album newAlbum = this.albumRepository.saveAndFlush(album);
            return newAlbum;
        }
        return null;
    }
    @Override
    public void deleteAlbum(int id) {
        Album deleteAlbum = this.albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not Found album"));
        this.albumRepository.delete(deleteAlbum);
    }
}
