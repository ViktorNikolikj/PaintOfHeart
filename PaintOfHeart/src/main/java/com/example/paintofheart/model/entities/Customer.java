package com.example.paintofheart.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "customer", schema = "project")
@PrimaryKeyJoinColumn(name = "id_user")
public class Customer extends User {

    @Column(name = "transaction_account", nullable = false, length = 50)
    String transactionAccount;

    public Customer(String username, String email, String surname, String name, String phoneNumber, String password, String transactionAccount) {
        super(username, email, surname, name, phoneNumber, password);
        this.transactionAccount = transactionAccount;
    }

    @Override
    public int userType() {
        return 3;
    }
}
