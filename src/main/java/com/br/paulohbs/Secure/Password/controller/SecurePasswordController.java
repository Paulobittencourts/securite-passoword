package com.br.paulohbs.Secure.Password.controller;


import com.br.paulohbs.Secure.Password.domain.PasswordDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/secure")
public class SecurePasswordController{

    @PostMapping("/validate-password")
    public ResponseEntity<?> validatePassword(@Valid @RequestBody PasswordDTO passwordDTO) {

        return ResponseEntity.ok().build();
    }


}
