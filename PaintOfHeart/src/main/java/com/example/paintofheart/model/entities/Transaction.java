package com.example.paintofheart.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "transactions", schema = "project")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_transaction")
    Integer id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_invoice", nullable = false)
    Integer invoiceId;

    @Column(name="edited_at", nullable = false)
    Date editedAt;

    @Column(name = "name", nullable = false, length = 50)
    String name;

    @Column(name="created_at", nullable = false)
    Date createdAt;

    @OneToOne
    @JoinColumn(name="id_cart")
    Cart cart;

    public Transaction(Date editedAt, String name, Date createdAt, Cart cart) {
        this.editedAt = editedAt;
        this.name = name;
        this.createdAt = createdAt;
        this.cart = cart;
    }

    public Customer getCustomer(){
        return this.getCart().getCustomer();
    }

}
