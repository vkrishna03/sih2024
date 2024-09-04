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

import com.gujarat.startup.service.IPRService;
import com.gujarat.startup.web.request.IPRRequest;
import com.gujarat.startup.web.response.IPRResponse;

@RestController
@RequestMapping("/ipr")
public class IPRAPI {
    final Logger logger = LoggerFactory.getLogger(IPRAPI.class);

    @Autowired
    IPRService iprService;

    @PostMapping
    public ResponseEntity<IPRResponse> createIPR(@RequestBody IPRRequest iprRequest) {
        IPRResponse iprResponse = iprService.createIPR(iprRequest);
        if(iprResponse == null) {
            logger.info("IPRResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(iprResponse);
    }

    @PutMapping
    public ResponseEntity<IPRResponse> updateIPR(@RequestBody IPRRequest iprRequest) {
        IPRResponse iprResponse = iprService.updateIPR(iprRequest);
        if(iprResponse == null) {
            logger.info("IPRResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(iprResponse);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<IPRResponse> getIPRByUserId(Long userId) {
        IPRResponse iprResponse = iprService.getIPRByUserId(userId);
        if(iprResponse == null) {
            logger.info("IPRResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(iprResponse);
    }

    @GetMapping("/accountId/{accountId}")
    public ResponseEntity<IPRResponse> getIPRByAccountId(Long accountId) {
        IPRResponse iprResponse = iprService.getIPRByAccountId(accountId);
        if(iprResponse == null) {
            logger.info("IPRResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(iprResponse);
    }

    @GetMapping("/iprId/{iprId}")
    public ResponseEntity<IPRResponse> getIPRByIprId(Long iprId) {
        IPRResponse iprResponse = iprService.getIPRById(iprId);
        if(iprResponse == null) {
            logger.info("IPRResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(iprResponse);
    }

    @DeleteMapping("/iprId/{iprId}")
    public ResponseEntity<IPRResponse> deleteIPRByIprId(Long iprId) {
        IPRResponse iprResponse = iprService.deleteIPRById(iprId);
        if(iprResponse == null) {
            logger.info("IPRResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(iprResponse);
    }

}