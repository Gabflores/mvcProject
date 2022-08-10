package com.example.demo.service;

import com.example.demo.model.RegistrationRequest;
import org.springframework.stereotype.Service;
@Service
public class RegistrationService {

    public static String register(RegistrationRequest request) {
        return "it works";
    }
}
