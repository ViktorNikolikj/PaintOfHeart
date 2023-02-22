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
@Table(name = "artist_acts_theatre", schema = "project")
@IdClass(ArtistActsTheatreId.class)
public class ArtistActsTheatre {

    @Id
    @Column(name="id_event_theatre")
    Integer theatreEventId;

    @Id
    @Column(name="id_user_artist")
    Integer artistId;

    public ArtistActsTheatre(Integer theatreEventId, Integer artistId) {
        this.theatreEventId = theatreEventId;
        this.artistId = artistId;
    }
}
