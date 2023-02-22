package com.example.paintofheart.service.impl;

import com.example.paintofheart.model.entities.Admin;
import com.example.paintofheart.model.exceptions.InvalidAdminIdException;
import com.example.paintofheart.repository.AdminRepository;
import com.example.paintofheart.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Override
    public List<Admin> findAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin findById(int id) {
        return adminRepository.findById(id).orElseThrow(() -> new InvalidAdminIdException());
    }

    @Override
    public Admin create(String username, String email, String surname, String name, String phoneNumber, String password) {
        Admin admin = new Admin(username, email, surname, name, phoneNumber, password);
        return this.adminRepository.save(admin);
    }

    @Override
    public Admin update(int id, String username, String email, String surname, String name, String phoneNumber, String password) {
        Admin admin = this.adminRepository.findById(id).orElseThrow(() -> new InvalidAdminIdException());
        admin.setUsername(username);
        admin.setEmail(email);
        admin.setSurname(surname);
        admin.setName(name);
        admin.setPhoneNumber(phoneNumber);
        admin.setPassword(password);
        return this.adminRepository.save(admin);
    }

    @Override
    public Admin delete(int id) {
        Admin admin = this.adminRepository.findById(id).orElseThrow(() -> new InvalidAdminIdException());
        this.adminRepository.delete(admin);
        return admin;
    }
}
