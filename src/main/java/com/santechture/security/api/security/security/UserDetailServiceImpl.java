package com.santechture.security.api.security.security;

import com.santechture.security.data.model.User;
import com.santechture.security.data.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("user det service haloooooooooooooooo");
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("USERNAME NOT FOUND"));
        return new UserDetailsImpl(user);
    }
}