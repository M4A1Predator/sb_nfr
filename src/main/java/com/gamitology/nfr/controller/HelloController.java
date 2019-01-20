package com.gamitology.nfr.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {

    private static final Logger logger = LogManager.getLogger(HelloController.class);

    @GetMapping
    public ResponseEntity<String> hello() {
        logger.info("Hello!!!");
        return ResponseEntity.ok("hello");
    }

}
