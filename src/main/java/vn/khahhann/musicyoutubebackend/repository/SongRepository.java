package vn.khahhann.musicyoutubebackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import vn.khahhann.musicyoutubebackend.entity.Song;

import java.util.List;

@CrossOrigin(origins = "http://192.168.51.102:8081")
@RepositoryRestResource(path = "song")
public interface SongRepository extends JpaRepository<Song, Integer> {
    List<Song> findByRankingLessThanOrderByRanking(int ranking);
    List<Song> findByAlbumIsRecapTrue();
    List<Song> findByAlbumIsRadioTrue();
    List<Song> findByAlbumIsPlaylistTrue();
    List<Song> findByAlbumIsAlbumTrue();
    List<Song>  findByIsStartSongTrue();
    List<Song>  findByIsHitTodayTrue();
    List<Song> findBySongNameContaining(@RequestParam("songName") String songName);

}

