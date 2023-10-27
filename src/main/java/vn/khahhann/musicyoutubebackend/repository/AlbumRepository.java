package vn.khahhann.musicyoutubebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.khahhann.musicyoutubebackend.entity.Album;

import java.util.List;

@RepositoryRestResource(path = "albums")
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    List<Album> findByIsRecapTrue();
    List<Album> findByIsRadioTrue();
    List<Album> findByIsAlbumTrue();
    List<Album> findByIsPlaylistTrue();
    Album findByAlbumName(String albumNames);


}
