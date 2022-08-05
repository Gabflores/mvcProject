package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/")
    public ResponseEntity<List<Admin>> getAdmins(){
        return ResponseEntity.ok().body(adminService.getAdmins());
    }


    @PostMapping("/save")
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
        return ResponseEntity.ok().body(adminService.saveAdmin(admin));
    }


}
