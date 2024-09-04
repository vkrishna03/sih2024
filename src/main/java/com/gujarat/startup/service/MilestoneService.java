package com.gujarat.startup.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gujarat.startup.entity.Milestone;
import com.gujarat.startup.repository.FundingRepo;
import com.gujarat.startup.repository.MilestoneRepo;
import com.gujarat.startup.repository.UserRepository;
import com.gujarat.startup.web.request.MilestoneRequest;
import com.gujarat.startup.web.response.MilestoneResponse;

@Service
public class MilestoneService {

    final Logger logger = LoggerFactory.getLogger(MilestoneService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    FundingRepo fundingRepo;

    @Autowired
    MilestoneRepo milestoneRepo;


    public MilestoneResponse createMilestone(MilestoneRequest milestoneRequest) {
        if(milestoneRequest == null || milestoneRequest.getMilestones() == null || milestoneRequest.getMilestones().isEmpty()) {
            logger.info("MilestoneRequest is null or empty");
            return null;
        }
        MilestoneResponse milestoneResponse = MilestoneResponse.builder().build();
        for(Milestone milestone : milestoneRequest.getMilestones()) {
            if(!userRepository.existsById(milestone.getUserId())) {
                logger.info("User not found for userId: " + milestone.getUserId());
                continue;
            }
            if(!fundingRepo.existsById(milestone.getFundingId())) {
                logger.info("Funding not found for fundingId: " + milestone.getFundingId());
                continue;
            }
            milestoneResponse.addMilestone(milestoneRepo.save(milestone));
        }
        return milestoneResponse;
    }

    public MilestoneResponse updateMilestone(MilestoneRequest milestoneRequest) {
        if(milestoneRequest == null || milestoneRequest.getMilestones() == null || milestoneRequest.getMilestones().isEmpty()) {
            logger.info("MilestoneRequest is null or empty");
            return null;
        }

        MilestoneResponse milestoneResponse = MilestoneResponse.builder().build();
        for(Milestone milestone : milestoneRequest.getMilestones()) {
            if(!userRepository.existsById(milestone.getUserId())) {
                logger.info("User not found for userId: " + milestone.getUserId());
                continue;
            }
            if(!fundingRepo.existsById(milestone.getFundingId())) {
                logger.info("Funding not found for fundingId: " + milestone.getFundingId());
                continue;
            }
            if(!milestoneRepo.existsById(milestone.getId())) {
                logger.info("Milestone not found for id: " + milestone.getId());
                continue;
            }
            milestoneResponse.addMilestone(milestoneRepo.save(milestone));
        }
        return milestoneResponse;
    }


    public MilestoneResponse deleteMilestoneById(Long id) {
        if(id == null) {
            logger.info("Id is null");
            return null;
        }
        if(!milestoneRepo.existsById(id)) {
            logger.info("Milestone not found for id: " + id);
            return null;
        }
        milestoneRepo.deleteById(id);
        return MilestoneResponse.builder().build();
    }

    public MilestoneResponse getMilestoneByUserId(Long userId) {
        if(userId == null) {
            logger.info("UserId is null");
            return null;
        }
        List<Milestone> milestones = milestoneRepo.findByUserId(userId);
        if(milestones == null || milestones.isEmpty()) {
            logger.info("Milestones not found for userId: " + userId);
            return null;
        }
        MilestoneResponse milestoneResponse = MilestoneResponse.builder().build();
        for(Milestone milestone : milestones) {
            milestoneResponse.addMilestone(milestone);
        }
        return milestoneResponse;
    }

    public MilestoneResponse getMilestoneById(Long id) {
        if(id == null) {
            logger.info("Id is null");
            return null;
        }
        if(!milestoneRepo.existsById(id)) {
            logger.info("Milestone not found for id: " + id);
            return null;
        }
        Milestone milestone = milestoneRepo.findById(id).get();
        MilestoneResponse milestoneResponse = MilestoneResponse.builder().build();
        milestoneResponse.addMilestone(milestone);
        return milestoneResponse;
    }

    public MilestoneResponse getMilestoneByFundingId(Long fundingId) {
        if(fundingId == null) {
            logger.info("FundingId is null");
            return null;
        }
        List<Milestone> milestones = milestoneRepo.findByFundingId(fundingId);
        if(milestones == null || milestones.isEmpty()) {
            logger.info("Milestones not found for fundingId: " + fundingId);
            return null;
        }
        MilestoneResponse milestoneResponse = MilestoneResponse.builder().build();
        for(Milestone milestone : milestones) {
            milestoneResponse.addMilestone(milestone);
        }
        return milestoneResponse;
    }

    
}

