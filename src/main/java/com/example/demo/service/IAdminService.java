package com.example.demo.service;

import com.example.demo.model.Admin;

import java.util.List;

public interface IAdminService {
    Admin saveAdmin(Admin admin);

    Admin getAdmin(String username);

    List<Admin> getAdmins();
}
