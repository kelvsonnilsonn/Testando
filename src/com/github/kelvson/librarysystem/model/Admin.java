package com.github.kelvson.librarysystem.model;

public class Admin extends Client {
    public Admin(String name, String cpf, String email, char gender) {
        super(name, cpf, email, gender);
        changeAdminStatus(true);
    }
}
