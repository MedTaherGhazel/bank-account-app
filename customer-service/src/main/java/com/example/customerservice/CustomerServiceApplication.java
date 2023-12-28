package com.example.customerservice;

import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            Customer customer1= Customer.builder()
                    .firstname("Mohamed")
                    .lastname("Ghazel")
                    .email("ghazel@gmail.com")
                    .build();
            Customer customer2= Customer.builder()
                    .firstname("Foulen")
                    .lastname("Fouleni")
                    .email("Fouleni@gmail.com")
                    .build();
            customerRepository.save(customer1);
            customerRepository.save(customer2);
        };
    }

}
