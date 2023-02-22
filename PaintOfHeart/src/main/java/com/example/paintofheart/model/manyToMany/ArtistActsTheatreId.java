package com.example.paintofheart.model.manyToMany;

import lombok.Data;

import java.io.Serializable;

@Data
public class ArtistActsTheatreId implements Serializable {

    Integer theatreEventId;
    Integer artistId;

}
