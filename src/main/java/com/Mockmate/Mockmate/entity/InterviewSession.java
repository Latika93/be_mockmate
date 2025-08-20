package com.Mockmate.Mockmate.entity;

import jakarta.persistence.*;

@Entity
public class InterviewSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String roomId; // Unique ID for the video call room

    public InterviewSession() {
        // No-argument constructor required by JPA
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}