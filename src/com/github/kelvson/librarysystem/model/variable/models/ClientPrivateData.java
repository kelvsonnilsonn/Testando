package com.github.kelvson.librarysystem.model.variable.models;

import com.github.kelvson.librarysystem.model.validate.models.cpf.CPF;
import com.github.kelvson.librarysystem.model.validate.models.email.Email;
import com.github.kelvson.librarysystem.model.validate.models.password.Password;

public abstract class ClientPrivateData {

    private String name;
    private Password password;
    private Email email;
    private final CPF cpf;

    protected ClientPrivateData(String name, String password, String email, String cpf) {
        this.name = name;
        this.password = new Password(password);
        this.email = new Email(email);
        this.cpf = new CPF(cpf);
    }

    public String getName(){ return this.name; }
    public String getCPFNumber() { return this.cpf.getCpf(); }
    public String getEmailAddress() { return this.email.getEmail(); }
    public String getUserPassword() { return this.password.getUserPassword(); }
}
