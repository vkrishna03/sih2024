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

import com.gujarat.startup.service.FundingService;
import com.gujarat.startup.web.request.FundingRequest;
import com.gujarat.startup.web.response.FundingResponse;

@RestController
@RequestMapping("/funding")
public class FundingAPI {
    final Logger logger = LoggerFactory.getLogger(FundingAPI.class);

    @Autowired
    FundingService fundingService;

    @PostMapping
    public ResponseEntity<FundingResponse> createFunding(@RequestBody FundingRequest fundingRequest) {
        FundingResponse fundingResponse = fundingService.createFunding(fundingRequest);
        if(fundingResponse == null) {
            logger.info("FundingResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(fundingResponse);
    }

    @PutMapping
    public ResponseEntity<FundingResponse> updateFunding(@RequestBody FundingRequest fundingRequest) {
        FundingResponse fundingResponse = fundingService.updateFunding(fundingRequest);
        if(fundingResponse == null) {
            logger.info("FundingResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(fundingResponse);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<FundingResponse> getFundingByUserId(Long userId) {
        FundingResponse fundingResponse = fundingService.getFundingByUserId(userId);
        if(fundingResponse == null) {
            logger.info("FundingResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(fundingResponse);
    }

    @GetMapping("/accountId/{accountId}")
    public ResponseEntity<FundingResponse> getFundingByAccountId(Long accountId) {
        FundingResponse fundingResponse = fundingService.getFundingByAccountId(accountId);
        if(fundingResponse == null) {
            logger.info("FundingResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(fundingResponse);
    }

    @GetMapping("/fundingId/{fundingId}")
    public ResponseEntity<FundingResponse> getFundingByFundingId(Long fundingId) {
        FundingResponse fundingResponse = fundingService.getFundingById(fundingId);
        if(fundingResponse == null) {
            logger.info("FundingResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(fundingResponse);
    }

    @GetMapping("/projectId/{projectId}")
    public ResponseEntity<FundingResponse> getFundingByProjectId(Long projectId) {
        FundingResponse fundingResponse = fundingService.getFundingByProjectId(projectId);
        if(fundingResponse == null) {
            logger.info("FundingResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(fundingResponse);
    }

    @DeleteMapping("/fundingId/{fundingId}")
    public ResponseEntity<FundingResponse> deleteFundingByFundingId(Long fundingId) {
        FundingResponse fundingResponse = fundingService.deleteByFundingId(fundingId);
        if(fundingResponse == null) {
            logger.info("FundingResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(fundingResponse);
    }
}