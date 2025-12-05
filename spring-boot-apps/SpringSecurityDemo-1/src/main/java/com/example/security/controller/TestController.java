package com.example.security.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/user/data")
    public String userAccess() {
        return "USER Access Granted";
    }

    @GetMapping("/admin/data")
    public String adminAccess() {
        return "ADMIN Access Granted";
    }
}
