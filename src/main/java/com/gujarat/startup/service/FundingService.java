package com.gujarat.startup.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gujarat.startup.entity.Funding;
import com.gujarat.startup.repository.FundingRepo;
import com.gujarat.startup.repository.ProjectRepo;
import com.gujarat.startup.repository.UserRepository;
import com.gujarat.startup.web.request.FundingRequest;
import com.gujarat.startup.web.response.FundingResponse;

@Service
public class FundingService {

    final Logger logger = LoggerFactory.getLogger(FundingService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    FundingRepo fundingRepo;

    public FundingResponse createFunding(FundingRequest fundingRequest) {
        if(fundingRequest == null || fundingRequest.getFundings() == null || fundingRequest.getFundings().isEmpty()) {
            logger.info("FundingRequest is null or empty");
            return null;
        }
        FundingResponse fundingResponse = FundingResponse.builder().build();
        for(Funding funding : fundingRequest.getFundings()) {
            if(!userRepository.existsById(funding.getUserId())) {
                logger.info("User not found for userId: " + funding.getUserId());
                continue;
            }
            if(!projectRepo.existsById(funding.getProjectId())) {
                logger.info("Project not found for projectId: " + funding.getProjectId());
                continue;
            }
            fundingResponse.addFunding(fundingRepo.save(funding));
        }
        return fundingResponse;
    }

    public FundingResponse updateFunding(FundingRequest fundingRequest) {
        if(fundingRequest == null || fundingRequest.getFundings() == null || fundingRequest.getFundings().isEmpty()) {
            logger.info("FundingRequest is null or empty");
            return null;
        }

        FundingResponse fundingResponse = FundingResponse.builder().build();
        for(Funding funding : fundingRequest.getFundings()) {
            if(!userRepository.existsById(funding.getUserId())) {
                logger.info("User not found for userId: " + funding.getUserId());
                continue;
            }
            if(!projectRepo.existsById(funding.getProjectId())) {
                logger.info("Project not found for projectId: " + funding.getProjectId());
                continue;
            }
            if(!fundingRepo.existsById(funding.getId())) {
                logger.info("Funding not found for id: " + funding.getId());
                continue;
            }
            fundingResponse.addFunding(fundingRepo.save(funding));
        }
        return null;
    }

    public FundingResponse getFundingByUserId(Long userId) {
        if(userId == null) {
            logger.info("UserId is null");
            return null;
        }
        List<Funding> fundings = fundingRepo.findByUserId(userId);
        if(fundings == null || fundings.isEmpty()) {
            logger.info("Fundings not found for userId: " + userId);
            return null;
        }
        FundingResponse fundingResponse = FundingResponse.builder().build();
        for(Funding funding : fundings) {
            fundingResponse.addFunding(funding);
        }
        return fundingResponse;
    }

    public FundingResponse getFundingByProjectId(Long projectId) {
        if(projectId == null) {
            logger.info("ProjectId is null");
            return null;
        }
        List<Funding> fundings = fundingRepo.findByProjectId(projectId);
        if(fundings == null || fundings.isEmpty()) {
            logger.info("Fundings not found for projectId: " + projectId);
            return null;
        }
        FundingResponse fundingResponse = FundingResponse.builder().build();
        for(Funding funding : fundings) {
            fundingResponse.addFunding(funding);
        }
        return fundingResponse;
    }

    public FundingResponse getFundingById(Long id) {
        if(id == null) {
            logger.info("Id is null");
            return null;
        }
        Funding funding = fundingRepo.findById(id).orElse(null);
        if(funding == null) {
            logger.info("Funding not found for id: " + id);
            return null;
        }
        FundingResponse fundingResponse = FundingResponse.builder().build();
        fundingResponse.addFunding(funding);
        return fundingResponse;
    }

    public FundingResponse getFundingByAccountId(Long accountId) {
        if(accountId == null) {
            logger.info("AccountId is null");
            return null;
        }
        List<Funding> fundings = fundingRepo.findByAccountId(accountId);
        if(fundings == null || fundings.isEmpty()) {
            logger.info("Fundings not found for accountId: " + accountId);
            return null;
        }
        FundingResponse fundingResponse = FundingResponse.builder().build();
        for(Funding funding : fundings) {
            fundingResponse.addFunding(funding);
        }
        return fundingResponse;
    }

    public FundingResponse deleteByFundingId(Long id) {
        if(id == null) {
            logger.info("Id is null");
            return null;
        }
        Funding funding = fundingRepo.findById(id).orElse(null);
        if(funding == null) {
            logger.info("Funding not found for id: " + id);
            return null;
        }
        fundingRepo.delete(funding);
        return FundingResponse.builder().build();
    }

}