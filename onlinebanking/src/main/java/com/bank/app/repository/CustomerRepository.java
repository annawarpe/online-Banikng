package com.bank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.app.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String email);
}
