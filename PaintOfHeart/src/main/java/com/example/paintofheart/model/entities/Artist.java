package com.example.paintofheart.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "artist", schema = "project")
@PrimaryKeyJoinColumn(name = "id_user")
public class Artist extends User{

    @Column(name = "type_of_artist", nullable = false, length = 50)
    String type;

    @ManyToOne
    @JoinColumn(name="id_user_admin")
    Admin admin;

    public Artist(String username, String email, String surname, String name, String phoneNumber,String password, String type, Admin admin) {
        super(username, email, surname, name, phoneNumber, password);
        this.type = type;
        this.admin = admin;
    }

    @Override
    public int userType() {
        return 2;
    }
}
