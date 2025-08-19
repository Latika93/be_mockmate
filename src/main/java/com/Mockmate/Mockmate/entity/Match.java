package com.Mockmate.Mockmate.entity;

import com.Mockmate.Mockmate.enums.Level;
import jakarta.persistence.*;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String slotId;

    @ManyToOne
    @JoinColumn(name = "user1_id")
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2_id")
    private User user2;

    private String topic;

    @Enumerated(EnumType.STRING)
    private Level level;
}
