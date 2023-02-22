package com.example.paintofheart.repository;

import com.example.paintofheart.model.manyToMany.ArtistExhibitsGallery;
import com.example.paintofheart.model.manyToMany.ArtistExhibitsGalleryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistExhibitsGalleryRepository extends JpaRepository<ArtistExhibitsGallery, ArtistExhibitsGalleryId> {
}
