package com.gujarat.startup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gujarat.startup.entity.Milestone;

@Repository
public interface MilestoneRepo extends JpaRepository<Milestone, Long> {

    List<Milestone> findByUserId(Long userId);

    List<Milestone> findByFundingId(Long fundingId);

}
