package vn.khahhann.musicyoutubebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "album_name", length = 256)
    private String albumName;

    @Column(name = "description", length = 256)
    private String description;

    @Column(name = "is_album")
    private boolean isAlbum;

    @Column(name = "is_radio")
    private boolean isRadio;

    @Column(name = "is_recap")
    private boolean isRecap;

    @Column(name = "is_playlist")
    private boolean isPlaylist;

    @Column(name = "icon", columnDefinition = "LONGTEXT")
    @Lob
    private String icon;

    @Column(name="image_data", columnDefinition = "LONGTEXT")
    @Lob
    private String image;

    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Song> songList;
}
