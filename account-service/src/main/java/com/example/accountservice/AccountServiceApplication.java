package com.example.accountservice;


import com.example.accountservice.entities.BankAccount;
import com.example.accountservice.enums.AccountType;
import com.example.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){
        return args -> {
          BankAccount account1=BankAccount.builder()
                  .accountId(UUID.randomUUID().toString())
                  .currency("MAD")
                  .balance(90000)
                  .createdAt(LocalDate.now())
                  .type(AccountType.SAVING_ACCOUNT)
                  .customerId(Long.valueOf(1))
                  .build();
            BankAccount account2 =BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balance(10000)
                    .createdAt(LocalDate.now())
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(Long.valueOf(1))
                    .build();
            bankAccountRepository.save(account1);
            bankAccountRepository.save(account2);

        };
    }
}
