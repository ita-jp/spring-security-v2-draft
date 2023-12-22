package com.example.securedapp.service.user;

import com.example.securedapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(u -> org.springframework.security.core.userdetails.User.builder()
                        .username(u.username())
                        .password(u.password())
                        .authorities(findAuthorities(u.username()))
                        .build()
                )
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }

    private String[] findAuthorities(String username) {
        return userRepository.findAuthoritiesByUsername(username)
                .stream()
                .map(Enum::name)
                .toArray(String[]::new);
    }

    @Transactional
    public void create(String username, String rawPassword) {
        val encodedPassword = passwordEncoder.encode(rawPassword);
        userRepository.insert(username, encodedPassword);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
