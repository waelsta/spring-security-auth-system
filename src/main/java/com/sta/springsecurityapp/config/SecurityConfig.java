package com.sta.springsecurityapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails wael = User.builder()
                .username("wael")
                .password("{noop}thisisus")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(wael);
    }

}