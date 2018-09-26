package com.example.springdiary.service;

import com.example.springdiary.model.Owner;
import com.example.springdiary.repository.UserRepo;
import com.example.springdiary.util.PasswordHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(UserRepo userRepo, BCryptPasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    public Owner findUserByName(String username) {
        return userRepo.findByUsername(username);
    }

    public boolean checkIfPasswordMatch(Owner owner, String password) {
        return encoder.matches(password, owner.getPassword());
    }

    public void saveUser(Owner owner) {
        owner.setPassword(encoder.encode(owner.getPassword()));
        userRepo.save(owner);
    }
}
