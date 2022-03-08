package com.auth.jwttoken.service;

import java.util.Collection;
import java.util.Collections;

import com.auth.jwttoken.model.User;
import com.auth.jwttoken.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("username not exist"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                                                                    user.getPassword(),
                                                                    true, true, true, true,
                                                                    getAuthorities(user.getRole())
                                                                    );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }   
    
}
