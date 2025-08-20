package com.Mockmate.Mockmate.repository;

import com.Mockmate.Mockmate.entity.InterviewSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewSlotRepository extends JpaRepository<InterviewSlot, Long> {

}