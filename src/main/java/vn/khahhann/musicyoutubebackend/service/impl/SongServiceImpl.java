package vn.khahhann.musicyoutubebackend.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.khahhann.musicyoutubebackend.entity.Album;
import vn.khahhann.musicyoutubebackend.entity.Song;
import vn.khahhann.musicyoutubebackend.repository.AlbumRepository;
import vn.khahhann.musicyoutubebackend.repository.SongRepository;
import vn.khahhann.musicyoutubebackend.service.SongService;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private AlbumRepository albumRepository; // Assuming you have an AlbumRepository

    @Override
    public Song addSongToAlbum(String albumName, Song originalSong) {
        Album existingAlbum = albumRepository.findByAlbumName(albumName);

        if (existingAlbum == null) {
            existingAlbum = new Album();
            existingAlbum.setAlbumName(albumName);

            albumRepository.saveAndFlush(existingAlbum);
        }

        Integer maxRanking = songRepository.findMaxRankingInAlbum(existingAlbum.getAlbumName());

        if (maxRanking == null) {
            maxRanking = 0;
        }

        int newRanking = maxRanking + 1;

        // Create a new instance of the song with the same content
        Song newSong = new Song();
        newSong.setSongName(originalSong.getSongName());
        newSong.setAuthor(originalSong.getAuthor());
        newSong.setRanking(newRanking);
        newSong.setDescription(originalSong.getDescription());
        newSong.setImage(originalSong.getImage());
        newSong.setStartSong(originalSong.isStartSong());
        newSong.setHitToday(originalSong.isHitToday());
        newSong.setAlbum(existingAlbum);

        // Save the new song with the existing or new album
        songRepository.saveAndFlush(newSong);

        return newSong;
    }

    @Override
    public void removeSongFromAlbum(int songId) {
        Song songToRemove = songRepository.findById(songId)
                .orElseThrow(() -> new EntityNotFoundException("Song not found"));

        this.songRepository.delete(songToRemove);
    }
}
