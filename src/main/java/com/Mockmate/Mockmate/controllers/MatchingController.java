package com.Mockmate.Mockmate.controllers;

import com.Mockmate.Mockmate.entity.User;
import com.Mockmate.Mockmate.services.MatchingService;
import com.Mockmate.Mockmate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/match")
public class MatchingController {

    private final MatchingService matchingService;
    private final UserService userService; // To find the current user

    @Autowired
    public MatchingController(MatchingService matchingService, UserService userService) {
        this.matchingService = matchingService;
        this.userService = userService;
    }

    // POST /api/match
    @PostMapping
    public ResponseEntity<Map<String, Object>> createMatch(@RequestBody Map<String, String> request) {
        String topic = request.get("topic");
        String level = request.get("level");

        Optional<User> matchedUser = matchingService.findMatch(topic, level);

        if (matchedUser.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "Match found");
            response.put("matchedUserId", matchedUser.get().getId());
            response.put("matchedUserName", matchedUser.get().getName());
            return ResponseEntity.ok(response);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "No match found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // GET /api/match/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getMatchDetails(@PathVariable Long id) {
        // In a real application, you would check a database for ongoing matches.
        // For now, we'll return a placeholder response.
        Map<String, Object> response = new HashMap<>();
        response.put("matchId", id);
        response.put("status", "Match details for " + id);
        return ResponseEntity.ok(response);
    }
}