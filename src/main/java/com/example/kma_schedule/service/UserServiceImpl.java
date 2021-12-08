package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Role;
import com.example.kma_schedule.database.entity.User;
import com.example.kma_schedule.database.repository.RoleRepository;
import com.example.kma_schedule.database.repository.UserRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @EventListener
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        roleRepository.save(Role.builder().id(1L).name("USER").build());
        roleRepository.save(Role.builder().id(2L).name("ADMIN").build());
    }


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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
//        user.setPassword(user.getPassword());
        user.setRoles(Collections.singleton(new Role(1L, "USER")));
        if(errors.isEmpty()){
            userRepository.save(user);
        }
        return errors;
    }

//
//    public List<String> login(String username, String password) {
//        List<String> errors = new ArrayList<>();
//        Optional<User> foundUser = userRepository.findUserByUsernameIgnoreCase(username);
//        if (!foundUser.isPresent()) {
//            errors.add("Such username doesn't exist");
//        }else {
//            if(!bCryptPasswordEncoder.matches(password,foundUser.get().getPassword())){
//                errors.add("Password is incorrect");
//            }
//        }
//        return errors;
//    }
//
//
//    public Optional<User> findUserByUsername(String username) {
//        return userRepository.findUserByUsernameIgnoreCase(username);
//    }
}
