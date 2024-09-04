package com.gujarat.startup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gujarat.startup.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
