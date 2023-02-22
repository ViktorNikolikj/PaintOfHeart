package com.example.paintofheart.service;

import com.example.paintofheart.model.entities.User;

public interface UserService {
    User login(String username, String password);

}
