package com.example.accountservice.repository;

import com.example.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAcountRepository extends JpaRepository<BankAccount, String > {
}