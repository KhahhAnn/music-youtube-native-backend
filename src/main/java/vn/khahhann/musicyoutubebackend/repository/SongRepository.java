package vn.khahhann.musicyoutubebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.khahhann.musicyoutubebackend.entity.Song;

@RepositoryRestResource(path = "song")
public interface SongRepository extends JpaRepository<Song, Integer> {
}
