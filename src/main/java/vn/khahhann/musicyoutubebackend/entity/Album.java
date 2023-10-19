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

    @Column(name="image_data", columnDefinition = "LONGTEXT")
    @Lob
    private String image;

    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Song> songList;
}
