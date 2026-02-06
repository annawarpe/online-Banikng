package com.bank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bank.app.entity.Register;
import com.bank.app.repository.RegisterRepository;

@RestController
@RequestMapping("/api/register")
@CrossOrigin("*")
public class RegisterController {

@Autowired
private RegisterRepository repo;

@PostMapping
public String save(@RequestBody Register reg){

if(repo.existsByEmail(reg.getEmail())){
return "Email already exists";
}

repo.save(reg);
return "Account created successfully";
}
}
