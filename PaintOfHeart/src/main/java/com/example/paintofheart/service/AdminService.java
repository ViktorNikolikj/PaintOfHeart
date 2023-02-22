package com.example.paintofheart.service;

import com.example.paintofheart.model.entities.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> findAllAdmins();
    Admin findById(int id);
    Admin create(String username, String email, String surname, String name, String phoneNumber, String password);
    Admin update(int id,String username, String email, String surname, String name, String phoneNumber, String password);
    Admin delete(int id);
}
