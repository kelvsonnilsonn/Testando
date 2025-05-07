package com.github.kelvson.librarysystem.model.validate.models.password;

import java.util.Objects;

public class Password {
    private String pass;

    public Password(String pass){
        validate(pass);
        this.pass = pass;
    }

    public String getUserPassword() { return pass; }

    private void validate(String passToValidate){
        Objects.requireNonNull(passToValidate, "The password can't be null.");
        if(passToValidate.length() < 3 ) {
            throw new IllegalArgumentException("The password is too short.");
        }
    }
}
