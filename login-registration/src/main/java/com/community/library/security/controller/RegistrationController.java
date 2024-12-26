package com.community.library.security.controller;

import com.community.library.security.model.AppUser;
import com.community.library.security.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = "/signup",consumes = "application/json")
    public AppUser save(@RequestBody AppUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("UserName:" +user.getUsername());
        appUserService.save(user);

        return user;
    }

}
