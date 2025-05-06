package com.github.kelvson.librarysystem.model.variable.models;

import com.github.kelvson.librarysystem.model.validate.models.cpf.CPF;
import com.github.kelvson.librarysystem.model.validate.models.email.Email;

public abstract class ClientInformation {
    private String name;
    private final CPF cpf;
    private Email email;
    private final char gender;
    private boolean isAdmin;
    private int clientId;

    public ClientInformation(String name, String cpf, String email, char gender){
        this.name = name;
        this.cpf = new CPF(cpf);
        this.email = new Email(email);
        this.gender = gender;
        this.isAdmin = false;
        this.clientId = -1;
    }

    public void setClientIdFromDataBase(int clientId) { this.clientId = clientId; }
    public int getClientId(){ return this.clientId; }

    public void changeAdminStatus(boolean status){ this.isAdmin = status; }
    public boolean getAdminStatus() { return this.isAdmin; }

    public String getName(){ return this.name; }
    public String getCPFNumber() { return this.cpf.getCpf(); }
    public String getEmailAddress() { return this.email.getEmail(); }
    public char getGender() { return this.gender;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("ID: ").append(this.getClientId()).append("\n")
                .append("Name: ").append(this.getName()).append("\n")
                .append("CPF: ").append(this.getCPFNumber()).append("\n")
                .append("Email: ").append(this.getEmailAddress()).append("\n")
                .append("Gender: ").append(Character.toUpperCase(this.getGender())).append("\n")
                .append("Admin: ").append(isAdmin).append("\n");

        return sb.toString();
    }
}
