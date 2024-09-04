package com.gujarat.startup.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gujarat.startup.entity.Funds;
import com.gujarat.startup.repository.FundsRepo;
import com.gujarat.startup.web.request.FundsRequest;
import com.gujarat.startup.web.response.FundsResponse;

@Service
public class FundsService {

    final Logger logger = LoggerFactory.getLogger(FundsService.class);

    @Autowired
    FundsRepo fundsRepo;

    public FundsResponse createFunds(FundsRequest fundsRequest) {
        if(fundsRequest == null || fundsRequest.getFunds() == null || fundsRequest.getFunds().isEmpty()) {
            logger.info("FundsRequest is null or empty");
            return null;
        }
        FundsResponse fundsResponse = FundsResponse.builder().build();
        for(Funds funds : fundsRequest.getFunds()) {
            fundsResponse.addFunds(fundsRepo.save(funds));
        }
        return fundsResponse;
    }

    public FundsResponse updateFunds(FundsRequest fundsRequest) {
        if(fundsRequest == null || fundsRequest.getFunds() == null || fundsRequest.getFunds().isEmpty()) {
            logger.info("FundsRequest is null or empty");
            return null;
        }

        FundsResponse fundsResponse = FundsResponse.builder().build();
        for(Funds funds : fundsRequest.getFunds()) {
            if(!fundsRepo.existsById(funds.getId())) {
                logger.info("Funds not found for id: " + funds.getId());
                continue;
            }
            fundsResponse.addFunds(fundsRepo.save(funds));
        }
        return null;
    }

    public FundsResponse getFundsByAccountId(Long accountId) {
        if(accountId == null) {
            logger.info("AccountId is null");
            return null;
        }
        List<Funds> funds = fundsRepo.findByAccountId(accountId);
        if(funds == null || funds.isEmpty()) {
            logger.info("Funds arr not found for accountId: " + accountId);
            return null;
        }
        FundsResponse fundsResponse = FundsResponse.builder().build();
        for(Funds fund : funds) {
            fundsResponse.addFunds(fund);
        }
        return fundsResponse;
    }

    public FundsResponse getFundsById(Long id) {
        if(id == null) {
            logger.info("Id is null");
            return null;
        }
        Funds fund = fundsRepo.findById(id).orElse(null);
        if(fund == null) {
            logger.info("Funds not found for id: " + id);
            return null;
        }
        FundsResponse fundsResponse = FundsResponse.builder().build();
        fundsResponse.addFunds(fund);
        return fundsResponse;
    }

    public FundsResponse deleteFundsById(Long id) {
        if(id == null) {
            logger.info("Id is null");
            return null;
        }
        Funds fund = fundsRepo.findById(id).orElse(null);
        if(fund == null) {
            logger.info("Funds not found for id: " + id);
            return null;
        }
        fundsRepo.delete(fund);
        return FundsResponse.builder().build();
    }
}

