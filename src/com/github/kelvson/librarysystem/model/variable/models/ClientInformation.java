package com.github.kelvson.librarysystem.model.variable.models;

import com.github.kelvson.librarysystem.model.validate.models.cpf.CPF;
import com.github.kelvson.librarysystem.model.validate.models.email.Email;
import com.github.kelvson.librarysystem.model.validate.models.password.Password;

public abstract class ClientInformation extends ClientPrivateData {
    private final char gender;
    private boolean isAdmin;
    private int clientId;

    public ClientInformation(String name, String password, String cpf, String email, char gender){
        super(name, password, email, cpf);
        this.gender = gender;
        this.isAdmin = false;
        this.clientId = -1;
    }

    public void setClientIdFromDataBase(int clientId) { this.clientId = clientId; }
    public int getClientId(){ return this.clientId; }

    public void changeAdminStatus(boolean status){ this.isAdmin = status; }
    public boolean getAdminStatus() { return this.isAdmin; }

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
