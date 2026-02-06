package com.bank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.app.entity.Account;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByCustomerId(Long customerId);

Account findByAccountNumber(Long accountNumber);
}
