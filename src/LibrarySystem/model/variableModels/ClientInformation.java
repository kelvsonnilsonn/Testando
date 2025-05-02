package LibrarySystem.model.variableModels;

import LibrarySystem.model.validateModels.CPF.CPF;
import LibrarySystem.model.validateModels.Email.Email;

public abstract class ClientInformation {
    private String name;
    private CPF cpf;
    private Email email;
    private char gender;

    public ClientInformation(String name, String cpf, String email, char gender){
        this.name = name;
        this.cpf = new CPF(cpf);
        this.email = new Email(email);
        this.gender = gender;
    }

    public String getName(){ return this.name; }
    public String getCPFNumber() { return this.cpf.getCpf(); }
    public String getEmailAddress() { return this.email.getEmail(); }
    public char getGender() { return this.gender;}
}
