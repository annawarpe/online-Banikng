package com.bank.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name="register")
public class Register {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String name;
private String email;
private String mobile;
private String accountType;
private String address;
private String password;

public Register(){}

public Long getId(){ return id;}

public String getName(){ return name;}
public void setName(String name){this.name=name;}

public String getEmail(){ return email;}
public void setEmail(String email){this.email=email;}

public String getMobile(){ return mobile;}
public void setMobile(String mobile){this.mobile=mobile;}

public String getAccountType(){ return accountType;}
public void setAccountType(String accountType){this.accountType=accountType;}

public String getAddress(){ return address;}
public void setAddress(String address){this.address=address;}

public String getPassword(){ return password;}
public void setPassword(String password){this.password=password;}
}
