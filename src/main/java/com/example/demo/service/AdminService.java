package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.repository.IAdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService implements IAdminService{

    private final IAdminRepository adminRepository;

    @Override
    public Admin saveAdmin(Admin admin) {
        log.info("Guardando admin {} en la base de datos", admin.getUsername());
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdmin(String username) {
        log.info("Buscando admin {} en la base de datos",username);
        return adminRepository.findByUsername(username);
    }

    @Override
    public List<Admin> getAdmins() {
        log.info("Buscando todos los admins de la base de datos");
        return adminRepository.findAll();
    }
}
