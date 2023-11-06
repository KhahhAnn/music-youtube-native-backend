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

    @Column(name = "ranking")
    private Integer ranking ;

    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;

    @Column(name="image_data", columnDefinition = "LONGTEXT")
    @Lob
    private String image;

    @Column(name="song_data", columnDefinition = "LONGTEXT")
    @Lob
    private String songData;

    @Column(name = "duration")
    private Integer duration;

    @Column(name="is_start_song")
    private boolean isStartSong;

    @Column(name="is_hit_today")
    private boolean isHitToday;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_album")
    private Album album;
}
