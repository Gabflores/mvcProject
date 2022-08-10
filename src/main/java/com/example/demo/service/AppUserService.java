package com.example.demo.service;

import com.example.demo.model.AppUser;
import com.example.demo.model.Role;
import com.example.demo.repository.IAppUserRepository;
import com.example.demo.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserService implements IAppUserService {

    private final IAppUserRepository userRepository;
    private final IRoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser user) { // Se crean usuario con role User por defecto
        log.info("Guardando nuevo usuario {} en la base de datos", user.getUsername());
        Role role = roleRepository.findByName("User");
        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public AppUser saveAdmin(AppUser user) {
        log.info("Guardando nuevo admin {} en la base de datos", user.getUsername());
        Role role= roleRepository.findByName("Admin");
        user.setRole(role);
        return userRepository.save(user);
    }


    @Override
    public AppUser getUser(String username) {
        log.info("Buscando admin {} en la base de datos",username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Buscando todos los admins de la base de datos");
        return userRepository.findAll();
    }

}
