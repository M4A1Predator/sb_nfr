package com.gamitology.nfr.service;

import com.gamitology.nfr.exception.MyException;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    public String testLog() {
        int a = Integer.parseInt("czxcxzczxcxz");
        return "";
    }

    public String testMyEx() throws Exception {
        throw new MyException("My Message");
    }
}
