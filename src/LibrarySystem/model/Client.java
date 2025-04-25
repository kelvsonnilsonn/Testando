package LibrarySystem.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private static int idCounter = 1;
    private String name;
    private String cpf;
    private char gender;
    private final int id;

    private List<Book> borrowedBooks = new ArrayList<>();

    public Client(String name, String cpf, char gender){
        this.name = name;
        this.cpf = cpf;
        this.gender = gender;

        this.id = idCounter++;
    }

    public int getId(){ return this.id; }
    public String getName(){ return this.name; }
    public String getCPF() { return this.cpf; }
    public char getGender() { return this.gender;}

}
