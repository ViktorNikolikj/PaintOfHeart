package com.example.paintofheart.model.entities;

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
@Table(name = "cart", schema = "project")
//@IdClass(CartId.class)
public class Cart {


    @ManyToOne
    @JoinColumn(name="id_user_customer")
    Customer customer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cart")
    Integer cartId;

    @Column(name="total", nullable = false)
    Integer total;

    public Cart(Customer customer, Integer total) {
        this.customer = customer;
        this.total = total;
    }

}
