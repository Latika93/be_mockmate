package com.Mockmate.Mockmate.controllers;

import com.Mockmate.Mockmate.entity.InterviewSession;
import com.Mockmate.Mockmate.services.InterviewSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/session")
public class InterviewSessionController {

    private final InterviewSessionService sessionService;

    @Autowired
    public InterviewSessionController(InterviewSessionService sessionService) {
        this.sessionService = sessionService;
    }

    // POST /api/session/start
    @PostMapping("/start")
    public ResponseEntity<InterviewSession> startSession() {
        InterviewSession session = sessionService.createSession();
        return new ResponseEntity<>(session, HttpStatus.CREATED);
    }

    // GET /api/session/{id}
    @GetMapping("/{id}")
    public ResponseEntity<InterviewSession> getSession(@PathVariable Long id) {
        return sessionService.getSessionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}