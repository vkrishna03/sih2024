package com.gujarat.startup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gujarat.startup.entity.Funds;

@Repository
public interface FundsRepo extends JpaRepository<Funds, Long> {

    List<Funds> findByAccountId(Long accountId);

}
