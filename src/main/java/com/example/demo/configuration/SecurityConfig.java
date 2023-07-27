package com.example.demo.configuration;

import com.example.demo.configuration.JwtAuthenticationFilter;
import com.example.demo.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static com.example.demo.model.ERoles.DISTRIBUTEUR;
import static com.example.demo.model.ERoles.LIVREUR;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new Users(1, DISTRIBUTEUR, "nomD","prenomD","email@distributeur","address","localisation","numTel", "password"),
            new Users(2, LIVREUR, "nomD","prenomD","email@livreur","address","localisation","numTel", "password"));
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeRequests()
            .anyRequest()
            .authenticated()
                .and()
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)

        ;
//            .and()
//            .httpBasic();
        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        return  new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                return APPLICATION_USERS
                        .stream()
                        .filter(u-> u.getUsername().equals(email))
                        .findFirst()
                        .orElseThrow(()-> new UsernameNotFoundException("no user was found"));
            }
        };
    }
}










