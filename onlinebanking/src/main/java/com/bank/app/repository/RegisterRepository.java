package com.bank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.app.entity.Register;

public interface RegisterRepository extends JpaRepository<Register,Long>{

boolean existsByEmail(String email);
 Register findByEmailAndPassword(String email, String password);
}
