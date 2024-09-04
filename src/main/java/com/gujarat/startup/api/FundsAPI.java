package com.gujarat.startup.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gujarat.startup.service.FundsService;
import com.gujarat.startup.web.request.FundsRequest;
import com.gujarat.startup.web.response.FundsResponse;

@Service
@RestController
@RequestMapping("/funds")
public class FundsAPI {

    final Logger logger = LoggerFactory.getLogger(FundsAPI.class);

    @Autowired
    FundsService fundsService;

    @PostMapping
    public ResponseEntity<FundsResponse> createFunds(@RequestBody FundsRequest fundsRequest) {
        FundsResponse fundsResponse = fundsService.createFunds(fundsRequest);
        if(fundsResponse == null) {
            logger.info("FundsResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(fundsResponse);
    }

    @PutMapping
    public ResponseEntity<FundsResponse> updateFunds(@RequestBody FundsRequest fundsRequest) {
        FundsResponse fundsResponse = fundsService.updateFunds(fundsRequest);
        if(fundsResponse == null) {
            logger.info("FundsResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(fundsResponse);
    }

    @GetMapping("/accountId/{accountId}")
    public ResponseEntity<FundsResponse> getFundsByAccountId(Long accountId) {
        FundsResponse fundsResponse = fundsService.getFundsByAccountId(accountId);
        if(fundsResponse == null) {
            logger.info("FundsResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(fundsResponse);
    }

    @GetMapping("/fundId/{fundId}")
    public ResponseEntity<FundsResponse> getFundsByFundId(Long fundId) {
        FundsResponse fundsResponse = fundsService.getFundsById(fundId);
        if(fundsResponse == null) {
            logger.info("FundsResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(fundsResponse);
    }

    @DeleteMapping("/fundId/{fundId}")
    public ResponseEntity<FundsResponse> deleteFundsByFundId(Long fundId) {
        FundsResponse fundsResponse = fundsService.deleteFundsById(fundId);
        if(fundsResponse == null) {
            logger.info("FundsResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(fundsResponse);
    }
}