package com.fatidev.FatiHotel.service;

import com.fatidev.FatiHotel.exception.OurException;
import com.fatidev.FatiHotel.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.CodeSource;

@Service
public class CustumUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(()-> new OurException("username/email not found"));
    }
}
