package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.repository.IAdminRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AdminService implements IAdminService{

    private final IAdminRepository adminRepository;

    @Override
    public Admin saveAdmin(Admin admin) {
        log.info("Saving admin {} in the database", admin.getUsername());
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdmin(String username) {
        log.info("Searching admin {} in the database",username);
        return adminRepository.findByUsername(username);
    }

    @Override
    public List<Admin> getAdmins() {
        log.info("Searching all admins in the database");
        return adminRepository.findAll();
    }
}
