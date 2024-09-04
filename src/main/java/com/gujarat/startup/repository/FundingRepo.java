package com.gujarat.startup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gujarat.startup.entity.Funding;

@Repository
public interface FundingRepo extends JpaRepository<Funding, Long> {

    List<Funding> findByUserId(Long userId);

    List<Funding> findByProjectId(Long projectId);

    List<Funding> findByAccountId(Long accountId);

}
