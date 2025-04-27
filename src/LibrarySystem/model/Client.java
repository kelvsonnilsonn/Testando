package LibrarySystem.model;

import LibrarySystem.model.validateModels.CPF.CPF;
import LibrarySystem.model.validateModels.Email.Email;

public class Client {
    private final int id;
    private String name;
    private CPF cpf;
    private Email email;
    private char gender;

    public Client(int id, String name, CPF cpf, Email email, char gender){
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.gender = gender;
    }

    public int getId(){ return this.id; }
    public String getName(){ return this.name; }
    public String getCPFNumber() { return this.cpf.getCpf(); }
    public String getEmailAddress() { return this.email.getEmail(); }
    public char getGender() { return this.gender;}

}
