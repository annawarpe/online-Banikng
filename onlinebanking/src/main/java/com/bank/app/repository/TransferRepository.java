package com.bank.app.repository;

import com.bank.app.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

    List<Transfer> findTop5ByAccountNoOrderByTxnDateDesc(Long accountNo);
}
