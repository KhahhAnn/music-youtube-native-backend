package vn.khahhann.musicyoutubebackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import vn.khahhann.musicyoutubebackend.entity.Song;

import java.util.List;

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
    Song findByAlbum_AlbumNameAndId(String albumName, int songId);
    @Query("SELECT s FROM Song s WHERE s.songName LIKE %:songName% AND s.album.id != 21")
    List<Song> findBySongNameContainingAndAlbumNotId(@Param("songName") String songName);
    @Query("SELECT MAX(s.ranking) FROM Song s WHERE s.album.albumName = :albumName")
    Integer findMaxRankingInAlbum(@Param("albumName") String albumName);

}


