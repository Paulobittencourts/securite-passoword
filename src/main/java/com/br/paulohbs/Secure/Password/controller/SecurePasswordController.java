package com.br.paulohbs.Secure.Password.controller;


import com.br.paulohbs.Secure.Password.domain.PasswordDTO;
import com.br.paulohbs.Secure.Password.service.SecurePasswordService;
import jakarta.validation.Valid;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/secure")
public class SecurePasswordController {

    @Autowired
    private SecurePasswordService securePasswordService;

    @PostMapping("/validate-password")
    public ResponseEntity<?> validatePassword(@Valid @RequestBody PasswordDTO passwordDTO) {
        final List<String> errors = securePasswordService
                .SecurePasswordValidation(passwordDTO.password());
        if(CollectionUtils.isEmpty(errors)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body(errors);
    }
}
