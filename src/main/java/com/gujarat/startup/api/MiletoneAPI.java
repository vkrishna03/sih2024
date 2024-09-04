package com.gujarat.startup.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gujarat.startup.service.MilestoneService;
import com.gujarat.startup.web.request.MilestoneRequest;
import com.gujarat.startup.web.response.MilestoneResponse;

@RestController
@RequestMapping("/milestone")
public class MiletoneAPI {
    final Logger logger = LoggerFactory.getLogger(MiletoneAPI.class);

    @Autowired
    MilestoneService milestoneService;

    @PostMapping
    public ResponseEntity<MilestoneResponse> createMilestone(@RequestBody MilestoneRequest milestoneRequest) {
        MilestoneResponse milestoneResponse = milestoneService.createMilestone(milestoneRequest);
        if(milestoneResponse == null) {
            logger.info("MilestoneResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(milestoneResponse);
    }

    @PutMapping
    public ResponseEntity<MilestoneResponse> updateMilestone(@RequestBody MilestoneRequest milestoneRequest) {
        MilestoneResponse milestoneResponse = milestoneService.updateMilestone(milestoneRequest);
        if(milestoneResponse == null) {
            logger.info("MilestoneResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(milestoneResponse);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<MilestoneResponse> getMilestoneByUserId(Long userId) {
        MilestoneResponse milestoneResponse = milestoneService.getMilestoneByUserId(userId);
        if(milestoneResponse == null) {
            logger.info("MilestoneResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(milestoneResponse);
    }

    @GetMapping("/fundingId/{fundingId}")
    public ResponseEntity<MilestoneResponse> getMilestoneByFundingId(Long fundingId) {
        MilestoneResponse milestoneResponse = milestoneService.getMilestoneByFundingId(fundingId);
        if(milestoneResponse == null) {
            logger.info("MilestoneResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(milestoneResponse);
    }

    @GetMapping("/milestoneId/{milestoneId}")
    public ResponseEntity<MilestoneResponse> getMilestoneByMilestoneId(Long milestoneId) {
        MilestoneResponse milestoneResponse = milestoneService.getMilestoneById(milestoneId);
        if(milestoneResponse == null) {
            logger.info("MilestoneResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(milestoneResponse);
    }

    @DeleteMapping("/milestoneId/{milestoneId}")
    public ResponseEntity<MilestoneResponse> deleteMilestoneByMilestoneId(Long milestoneId) {
        MilestoneResponse milestoneResponse = milestoneService.deleteMilestoneById(milestoneId);
        if(milestoneResponse == null) {
            logger.info("MilestoneResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(milestoneResponse);
    }
}