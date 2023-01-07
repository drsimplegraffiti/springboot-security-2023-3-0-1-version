package com.abcode.springboot.secured.controller;

import com.abcode.springboot.secured.repository.UserRepository;
import com.abcode.springboot.secured.response.AuthenticationRequest;
import com.abcode.springboot.secured.response.AuthenticationResponse;
import com.abcode.springboot.secured.service.AuthenticationService;
import com.abcode.springboot.secured.response.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final UserRepository repository;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        // 1. Check if user exists in database
        if (repository.existsByEmail(request.getEmail())) {
            // return 400 bad request as user already exists as message body in response
            return ResponseEntity.badRequest()
                    .body(AuthenticationResponse.builder()
                            .message("User already exists")
                            .build());

        }

        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }


}
