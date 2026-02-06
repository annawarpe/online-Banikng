package com.bank.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bank.app.entity.Customer;
import com.bank.app.entity.Account;
import com.bank.app.entity.Transfer;
import com.bank.app.repository.CustomerRepository;
import com.bank.app.repository.AccountRepository;
import com.bank.app.repository.TransferRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransferRepository transferRepository;

    // DASHBOARD
    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {

        String email = (String) session.getAttribute("email");
        if (email == null) return "redirect:/login/user";

        Customer customer = customerRepository.findByEmail(email);
        if (customer == null) return "redirect:/login/user";

        model.addAttribute("user", customer);

        List<Account> accounts = accountRepository.findByCustomerId(customer.getId());
        model.addAttribute("accounts", accounts);

        double totalBalance = accounts.stream().mapToDouble(Account::getBalance).sum();
        model.addAttribute("totalBalance", totalBalance);

        if (!accounts.isEmpty()) {
            Long accountNo = accounts.get(0).getAccountNumber();
            List<Transfer> transactions = transferRepository.findTop5ByAccountNoOrderByTxnDateDesc(accountNo);
            model.addAttribute("transactions", transactions);
        }

        return "userdashboard"; // templates/userdashboard.html
    }

    // LOGOUT
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/"; // back to home
    }

    // MAKE TRANSACTION
    @PostMapping("/transaction")
    public String transaction(@RequestParam Long accountNo,
                              @RequestParam String accountType,
                              @RequestParam Double amount,
                              @RequestParam String type) {

        Transfer t = new Transfer();
        t.setAccountNo(accountNo);
        t.setAccountType(accountType);
        t.setAmount(amount);
        t.setTransactionType(type);
        t.setDate(LocalDateTime.now());


        transferRepository.save(t);

        return "redirect:/customer/dashboard"; // redirect to dashboard after transaction
    }
}
