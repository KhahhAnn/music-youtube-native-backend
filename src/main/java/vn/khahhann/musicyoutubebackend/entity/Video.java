package vn.khahhann.musicyoutubebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "video_name", length = 256)
    private String videoName;

    @Column(name = "author", length = 256)
    private String author;

    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;

    @Column(name="video_data", columnDefinition = "LONGTEXT")
    @Lob
    private String videoData;

    @Column(name="image_data", columnDefinition = "LONGTEXT")
    @Lob
    private String image;
}
