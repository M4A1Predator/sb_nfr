package com.gamitology.nfr.controller;

import com.gamitology.nfr.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/bad")
@RestController
public class BadController {

    @Autowired
    MyService myService;

    @GetMapping
    public ResponseEntity<String> troll() {
        return ResponseEntity.badRequest().body("Bad Controller");
    }

    @GetMapping("/first")
    public ResponseEntity<String> frist() {
        myService.testLog();
        return ResponseEntity.ok("");
    }

    @GetMapping("/myex")
    public ResponseEntity<String> myex() throws Exception {
        myService.testMyEx();
        return ResponseEntity.ok("");
    }

    @GetMapping("/null")
    public ResponseEntity<String> testNull() {
        String s = null;
        s.toLowerCase();
        return ResponseEntity.ok("");
    }

}
