package com.gujarat.startup.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gujarat.startup.entity.IPR;
import com.gujarat.startup.repository.IPRRepo;
import com.gujarat.startup.repository.UserRepository;
import com.gujarat.startup.web.request.IPRRequest;
import com.gujarat.startup.web.response.IPRResponse;

@Service
public class IPRService {

    final Logger logger = LoggerFactory.getLogger(IPRService.class);

    @Autowired
    IPRRepo iprRepo;

    @Autowired
    UserRepository userRepository;


    public IPRResponse createIPR(IPRRequest iprRequest) {
        if(iprRequest == null || iprRequest.getIprs() == null || iprRequest.getIprs().isEmpty()) {
            logger.info("IPRRequest is null or empty");
            return null;
        }

        IPRResponse iprResponse = IPRResponse.builder().build();
        for(IPR ipr : iprRequest.getIprs()) {
            if(!userRepository.existsById(ipr.getUserId())) {
                logger.info("User not found for userId: " + ipr.getUserId());
                continue;
            }
            iprResponse.addIPR(iprRepo.save(ipr));
        }
        return iprResponse;
    }

    public IPRResponse updateIPR(IPRRequest iprRequest) {
        if(iprRequest == null || iprRequest.getIprs() == null || iprRequest.getIprs().isEmpty()) {
            logger.info("IPRRequest is null or empty");
            return null;
        }

        IPRResponse iprResponse = IPRResponse.builder().build();
        for(IPR ipr : iprRequest.getIprs()) {
            if(!userRepository.existsById(ipr.getUserId())) {
                logger.info("User not found for userId: " + ipr.getUserId());
                continue;
            }
            if(!iprRepo.existsById(ipr.getId())) {
                logger.info("IPR not found for id: " + ipr.getId());
                continue;
            }
            iprResponse.addIPR(iprRepo.save(ipr));
        }
        return iprResponse;
    }


    public IPRResponse deleteIPRById(Long id) {
        if(id == null) {
            logger.info("Id is null");
            return null;
        }
        if(!iprRepo.existsById(id)) {
            logger.info("IPR not found for id: " + id);
            return null;
        }

        iprRepo.deleteById(id);
        return IPRResponse.builder().build();
    }

    public IPRResponse getIPRByUserId(Long userId) {
        if(userId == null) {
            logger.info("UserId is null");
            return null;
        }
        List<IPR> iprs = iprRepo.findByUserId(userId);
        if(iprs == null || iprs.isEmpty()) {
            logger.info("IPRs not found for userId: " + userId);
            return null;
        }
        IPRResponse iprResponse = IPRResponse.builder().build();
        for(IPR ipr : iprs) {
            iprResponse.addIPR(ipr);
        }
        return iprResponse;
    }

    public IPRResponse getIPRById(Long id) {
        if(id == null) {
            logger.info("Id is null");
            return null;
        }
        IPR ipr = iprRepo.findById(id).orElse(null);
        if(ipr == null) {
            logger.info("IPR not found for id: " + id);
            return null;
        }
        IPRResponse iprResponse = IPRResponse.builder().build();
        iprResponse.addIPR(ipr);
        return iprResponse;
    }

    public IPRResponse getIPRByAccountId(Long accountId) {
        if(accountId == null) {
            logger.info("AccountId is null");
            return null;
        }
        List<IPR> iprs = iprRepo.findByAccountId(accountId);
        if(iprs == null || iprs.isEmpty()) {
            logger.info("IPRs not found for accountId: " + accountId);
            return null;
        }
        IPRResponse iprResponse = IPRResponse.builder().build();
        for(IPR ipr : iprs) {
            iprResponse.addIPR(ipr);
        }
        return iprResponse;
    }
}