package vn.khahhann.musicyoutubebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "song_name", length = 256)
    private String songName;

    @Column(name = "author", length = 256)
    private String author;

    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;

    @Column(name="image_data", columnDefinition = "LONGTEXT")
    @Lob
    private String image;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_album")
    private Album album;
}