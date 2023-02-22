package com.example.paintofheart.model.manyToMany;

import lombok.Data;

import java.io.Serializable;

@Data
public class ArtistExhibitsGalleryId implements Serializable {

    Integer galleryEventId;
    Integer artistId;

}
