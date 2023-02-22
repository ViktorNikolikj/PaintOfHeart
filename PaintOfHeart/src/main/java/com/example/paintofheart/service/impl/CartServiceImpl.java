package com.example.paintofheart.service.impl;

import com.example.paintofheart.model.entities.Cart;
import com.example.paintofheart.model.entities.Customer;
import com.example.paintofheart.model.exceptions.InvalidCartIdException;
import com.example.paintofheart.repository.CartRepository;
import com.example.paintofheart.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Cart> allCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart create(Customer customer, Integer total) {
        Cart cart = null;
        if(cartRepository.findByCustomer(customer) == null)
        {
            cart = new Cart(customer, total);
        }else {
            cart = cartRepository.findByCustomer(customer);
            int totalFromCart =  cart.getTotal();
            totalFromCart+=total;
            cart.setTotal(totalFromCart);
        }
            return this.cartRepository.save(cart);
    }

    @Override
    public Cart update(int id, Customer customer, Integer total) {
        Cart cart = this.cartRepository.findByCartId(id).orElseThrow(() -> new InvalidCartIdException());
        cart.setTotal(total);
        cart.setCustomer(customer);
        return this.cartRepository.save(cart);
    }

    @Override
    public Cart delete(int id) {
        Cart cart = this.cartRepository.findByCartId(id).orElseThrow(() -> new InvalidCartIdException());
        this.cartRepository.delete(cart);
        return cart;
    }

    @Override
    public Cart findById(int id) {
        return this.cartRepository.findByCartId(id).orElseThrow(() -> new InvalidCartIdException());
    }

    @Override
    public Cart findByCustomer(Customer customer) {
        return this.cartRepository.findByCustomer(customer);
    }
}
