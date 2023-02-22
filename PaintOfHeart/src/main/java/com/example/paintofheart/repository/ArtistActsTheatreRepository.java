package com.example.paintofheart.repository;

import com.example.paintofheart.model.manyToMany.ArtistActsTheatre;
import com.example.paintofheart.model.manyToMany.ArtistActsTheatreId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistActsTheatreRepository extends JpaRepository<ArtistActsTheatre, ArtistActsTheatreId> {
}
