package com.gujarat.startup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
public class Milestone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long accountId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long fundingId;

    @Column(nullable = false)
    private String milestoneName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String resourceUtil;

    @Column(nullable = false)
    private String docUrl;
}
