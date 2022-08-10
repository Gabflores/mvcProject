package com.example.demo.repository;

import com.example.demo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface IAdminRepository extends JpaRepository<Admin,Long> {
    Admin findByUsername(String username);
}
