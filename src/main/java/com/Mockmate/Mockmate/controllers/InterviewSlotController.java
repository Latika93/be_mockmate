package com.Mockmate.Mockmate.controllers;

import com.Mockmate.Mockmate.services.InterviewSlotService;
import com.Mockmate.Mockmate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mockmate.Mockmate.entity.InterviewSlot;
import com.Mockmate.Mockmate.entity.User;
import com.Mockmate.Mockmate.services.InterviewSlotService;
import com.Mockmate.Mockmate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slots")
public class InterviewSlotController {

    private final InterviewSlotService slotService;
    private final UserService userService;

    @Autowired
    public InterviewSlotController(InterviewSlotService slotService, UserService userService) {
        this.slotService = slotService;
        this.userService = userService;
    }

    // POST /api/slots
    @PostMapping
    public ResponseEntity<InterviewSlot> createSlot(@RequestBody InterviewSlot slot, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByEmail(userDetails.getUsername());
        InterviewSlot createdSlot = slotService.createSlot(slot, user);
        return new ResponseEntity<>(createdSlot, HttpStatus.CREATED);
    }

    // GET /api/slots
    @GetMapping
    public ResponseEntity<List<InterviewSlot>> getAllSlots() {
        List<InterviewSlot> slots = slotService.getAllSlots();
        return ResponseEntity.ok(slots);
    }

    // GET /api/slots/{id}
    @GetMapping("/{id}")
    public ResponseEntity<InterviewSlot> getSlotById(@PathVariable Long id) {
        return slotService.getSlotById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
