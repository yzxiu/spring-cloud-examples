package com.neo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class HelloController {

    InetAddress ia;

    {
        try {
            ia = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    String host = ia.getHostName();

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "hello " + name + "，this is " + host;
    }
}