package vn.khahhann.musicyoutubebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.khahhann.musicyoutubebackend.entity.Album;

@RepositoryRestResource(path = "album")
public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
