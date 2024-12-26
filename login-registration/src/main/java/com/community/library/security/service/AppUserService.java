package com.community.library.security.service;

import com.community.library.security.model.AppUser;
import com.community.library.security.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    public void save(AppUser user){
        appUserRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> user = appUserRepository.findByUsername(username) ;
        if(user.isPresent()){
            var userObj = user.get();
            return User.builder().username(userObj.getUsername()).password(userObj.getPassword()).build();
        }
        else{
            throw new UsernameNotFoundException(username);
        }
    }
}
