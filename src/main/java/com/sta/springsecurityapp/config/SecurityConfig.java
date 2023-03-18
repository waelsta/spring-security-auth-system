package com.sta.springsecurityapp.config;

import com.sta.springsecurityapp.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource){
       return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->{
            configurer.requestMatchers("/employees").hasAnyRole(Role.ADMIN.toString(), Role.EMPLOYEE.toString(), Role.VISITOR.toString());
            configurer.requestMatchers("/employees/delete").hasRole(Role.ADMIN.toString());
            configurer.requestMatchers("/employees/update/**").hasAnyRole(Role.ADMIN.toString(),Role.EMPLOYEE.toString());
        });
            //use http basic auth
        http.httpBasic();

        return http.build();
    }

}