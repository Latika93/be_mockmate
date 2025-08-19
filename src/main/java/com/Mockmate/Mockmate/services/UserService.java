package com.Mockmate.Mockmate.services;

import com.Mockmate.Mockmate.entity.User;
import com.Mockmate.Mockmate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository _userRepository;
    private final PasswordEncoder _passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder _passwordEncoder) {
        this._userRepository = userRepository;
        this._passwordEncoder = _passwordEncoder;
    }

    public User registerUser(User user){
        String encodedPassword = _passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return _userRepository.save(user);
    }
}
