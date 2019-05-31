package com.jelledv.springsecurityplayground.service;

import com.jelledv.springsecurityplayground.model.UserEntity;
import com.jelledv.springsecurityplayground.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class CustomDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> userEntityOptional = userRepository.findUserEntityByEmail(email);
        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            return new User(userEntity.getEmail(), userEntity.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority(userEntity.getRole().getName())));
        }

        throw new UsernameNotFoundException("user with email " + email + " not found");
    }
}
