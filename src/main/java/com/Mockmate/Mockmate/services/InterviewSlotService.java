package com.Mockmate.Mockmate.services;

import com.Mockmate.Mockmate.entity.InterviewSlot;
import com.Mockmate.Mockmate.entity.User;
import com.Mockmate.Mockmate.repository.InterviewSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewSlotService {
    private final InterviewSlotRepository slotRepository;

    @Autowired
    public InterviewSlotService(InterviewSlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    public InterviewSlot createSlot(InterviewSlot slot, User user) {
        slot.setUser(user);
        return slotRepository.save(slot);
    }

    public List<InterviewSlot> getAllSlots() {
        return slotRepository.findAll();
    }

    public Optional<InterviewSlot> getSlotById(Long id) {
        return slotRepository.findById(id);
    }
}
