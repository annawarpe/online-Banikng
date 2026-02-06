package com.bank.app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bank.app.entity.Message;
import com.bank.app.repository.MessageRepository;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin("*")
public class MessageController {

    @Autowired
    private MessageRepository repo;

    @PostMapping
    public Message send(@RequestBody Message msg){

        msg.setTimestamp(LocalDateTime.now());
        return repo.save(msg);
    }

    @GetMapping
    public List<Message> getAll(){
        return repo.findAll();
    }
}
