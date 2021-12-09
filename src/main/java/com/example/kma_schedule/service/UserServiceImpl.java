package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Role;
import com.example.kma_schedule.database.entity.User;
import com.example.kma_schedule.database.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> foundUser = userRepository.findUserByEmailIgnoreCase(s);
        if (!foundUser.isPresent()) {
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
        return foundUser.get();
    }

    public List<String> signup(User user) {
        List<String> errors = new ArrayList<>();

        Optional<User> usrByUsrnam = userRepository.findUserByUsernameIgnoreCase(user.getUsername());
        Optional<User> usrByMail = userRepository.findUserByEmailIgnoreCase(user.getEmail());

        if (usrByUsrnam.isPresent()) {
            errors.add("Username is taken. Try again");
        }

        if (usrByMail.isPresent()) {
            errors.add("Mail is taken. Try again");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(new Role(1L, "USER")));
        if(errors.isEmpty()){
            userRepository.save(user);
        }
        return errors;
    }
}
