package com.jelledv.springsecurityplayground.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unsecured")
public class UnsecuredController {

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Ja! Ik ben onbeveiligd! Kijk maar naar de configuratie in ResourceServerConfig!");
    }
}
