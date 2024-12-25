package com.community.library.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
        return  http.formLogin(form -> form.loginPage("/login").permitAll())
                .authorizeHttpRequests(register ->
                {
                    register.requestMatchers("/signup","/css/**","/js/**").permitAll();
                    register.anyRequest().authenticated();
                })
                .build();
    }
}
