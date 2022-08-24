package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Account;

public interface AccountRepo extends JpaRepository<Account, Long>{

}
