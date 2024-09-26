package com.br.paulohbs.Secure.Password.service.impl;

import com.br.paulohbs.Secure.Password.service.SecurePasswordService;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

@Service
public class DefaultSecurePasswordService implements SecurePasswordService {

    private static final String UPPERCASE_REGEX = ".*[A-Z].*";
    private static final String LOWERCASE_REGEX = ".*[a-z].*";
    private static final String DIGITS_REGEX = ".*[0-9].*";
    private static final String SPECIAL_CHAR_REGEX = ".*[\\W].*";


    @Override
    public List<String> SecurePasswordValidation(final String password) {
        final List<String> errors = new ArrayList<>();

        if (password.length() < 8) {
            errors.add("Password must be at least 8 characters");
        }

        if (!Pattern.matches(UPPERCASE_REGEX, password)) {
            errors.add("Must have at least one uppercase character");
        }

        if (!Pattern.matches(LOWERCASE_REGEX, password)) {
            errors.add("Must have at least one lowercase character");
        }

        if (!Pattern.matches(DIGITS_REGEX, password)) {
            errors.add("Must have at least one digit");
        }

        if (!Pattern.matches(SPECIAL_CHAR_REGEX, password)) {
            errors.add("Must have at least one special character");
        }
        return errors;
    }
}
