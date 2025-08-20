package com.Mockmate.Mockmate.services;

import com.Mockmate.Mockmate.entity.InterviewSession;
import com.Mockmate.Mockmate.repository.InterviewSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class InterviewSessionService {

    private final InterviewSessionRepository sessionRepository;

    @Autowired
    public InterviewSessionService(InterviewSessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public InterviewSession createSession() {
        InterviewSession session = new InterviewSession();
        // Generate a unique room ID
        session.setRoomId(UUID.randomUUID().toString());
        return sessionRepository.save(session);
    }

    public Optional<InterviewSession> getSessionById(Long id) {
        return sessionRepository.findById(id);
    }
}