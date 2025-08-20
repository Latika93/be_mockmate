package com.Mockmate.Mockmate.services;

import com.Mockmate.Mockmate.entity.User;
import com.Mockmate.Mockmate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatchingService {

    private final UserRepository userRepository;

    @Autowired
    public MatchingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findMatch(String topic, String level) {
        // Simple matching logic: find a user who has the same skill/topic and level
        // For a more advanced system, you would consider availability, real-time status, etc.
        List<User> users = userRepository.findAll();

        Optional<User> matchedUser = users.stream()
                .filter(user -> user.getSkills() != null && user.getSkills().contains(topic))
//                .filter(user -> user.getLevel() != null && user.getLevel().equals(level))
                .findFirst();

        return matchedUser;
    }
}