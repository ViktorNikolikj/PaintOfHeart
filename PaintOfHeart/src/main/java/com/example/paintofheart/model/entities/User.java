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
@Table(name = "users", schema = "project")
@Inheritance(strategy = InheritanceType.JOINED)
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    Integer id;

    @Column(name="username", nullable = false, length = 50)
    String username;

    @Column(name="email", nullable = false, length = 50)
    String email;

    @Column(name="surname", nullable = false, length = 50)
    String surname;

    @Column(name="name", nullable = false, length = 50)
    String name;

    @Column(name="phone_number", nullable = false, length = 50)
    String phoneNumber;

    @Column(name="password", nullable = false, length = 40, columnDefinition = "bpchar")
    String password;

    public User(String username, String email, String surname, String name, String phoneNumber, String password) {
        this.username = username;
        this.email = email;
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getFullName(){
        return String.format("%s %s", this.getName(), this.getSurname());
    }

    public int userType(){
        return 0;
    }

}
