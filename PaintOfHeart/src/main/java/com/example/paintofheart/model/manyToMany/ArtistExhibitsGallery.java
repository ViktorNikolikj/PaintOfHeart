package com.example.paintofheart.model.manyToMany;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "artist_exhibits_gallery", schema = "project")
@IdClass(ArtistExhibitsGalleryId.class)
public class ArtistExhibitsGallery {

    @Id
    @Column(name="id_event_gallery")
    Integer galleryEventId;

    @Id
    @Column(name="id_user_artist")
    Integer artistId;

    public ArtistExhibitsGallery(Integer galleryEventId, Integer artistId) {
        this.galleryEventId = galleryEventId;
        this.artistId = artistId;
    }
}
