package com.example.demo.service;

import com.example.demo.model.AppUser;

import java.util.List;

public interface IAppUserService {
    AppUser saveUser(AppUser user);

    AppUser saveAdmin(AppUser user);

    AppUser getUser(String username);

    List<AppUser> getUsers();

}
