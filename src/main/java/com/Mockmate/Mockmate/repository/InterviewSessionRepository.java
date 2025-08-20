package com.Mockmate.Mockmate.repository;

import com.Mockmate.Mockmate.entity.InterviewSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewSessionRepository extends JpaRepository<InterviewSession, Long> {
}