package com.example.paintofheart.service.impl;

import com.example.paintofheart.model.entities.User;
import com.example.paintofheart.model.exceptions.InvalidArgumentException;
import com.example.paintofheart.model.exceptions.InvalidUserCredentialException;
import com.example.paintofheart.repository.UserRepository;
import com.example.paintofheart.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;


    @Override
    public User login(String username, String password) {
        if(username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidArgumentException();
        return userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(InvalidUserCredentialException::new);
    }

}
