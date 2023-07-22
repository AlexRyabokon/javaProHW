package com.example.homework39.controllers;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PingController {
    private final PingController pingController;


    public PingController(@Lazy PingController pingController) {
        this.pingController = pingController;
    }

    @RequestMapping("/ping")
    public String ping() {
        return "OK";
    }


}
