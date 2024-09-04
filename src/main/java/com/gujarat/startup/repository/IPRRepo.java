package com.gujarat.startup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gujarat.startup.entity.IPR;

@Repository
public interface IPRRepo extends JpaRepository<IPR, Long> {

    List<IPR> findByUserId(Long userId);

    List<IPR> findByAccountId(Long accountId);

}
