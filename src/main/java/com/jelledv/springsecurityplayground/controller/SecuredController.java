package com.jelledv.springsecurityplayground.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/secured")
public class SecuredController {

    @GetMapping
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public ResponseEntity<Principal> get(final Principal principal) {
        return ResponseEntity.ok(principal);
    }

    // you need a valid access token, but don't require a specific role
    @GetMapping("/norole")
    public ResponseEntity<Principal> getOpen(final Principal principal) {
        return ResponseEntity.ok(principal);
    }
}
