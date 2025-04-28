package LibrarySystem;

import LibrarySystem.model.Book;
import LibrarySystem.model.validateModels.CPF.CPF;
import LibrarySystem.model.validateModels.Email.Email;
import LibrarySystem.services.BookManagerService.BookManagerApp;
import LibrarySystem.services.ClientManagerService.ClientManagerApp;

import java.sql.Date;
import java.util.Scanner;

public class LibraryApplication {
    private final BookManagerApp bookManager;
    private final ClientManagerApp clientManager;
    private final Scanner scan;

    public LibraryApplication(Scanner scan){
        this.scan = scan;
        this.bookManager = new BookManagerApp();
        this.clientManager = new ClientManagerApp();
    }

    public void run(){
        boolean running = true;

        while (running) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. List all books");
            System.out.println("2. List all clients");
            System.out.println("3. Add a new book");
            System.out.println("4. Remove a book");
            System.out.println("5. Add a new client");
            System.out.println("6. Borrow a book");
            System.out.println("7. Return a book");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            int option = scan.nextInt();
            scan.nextLine(); // consumir quebra de linha pendente

            try {
                switch (option) {
                    case 1:
                        listBooksFromLibrary();
                        break;
                    case 2:
                        listClientsFromLibrary();
                        break;
                    case 3:
                        System.out.print("Enter book title: ");
                        String title = scan.nextLine();
                        System.out.print("Enter author name: ");
                        String author = scan.nextLine();
                        System.out.print("Enter description: ");
                        String description = scan.nextLine();
                        System.out.print("Enter publication date (yyyy-mm-dd): ");
                        String dateStr = scan.nextLine();
                        createBook(title, author, description, Date.valueOf(dateStr));
                        break;
                    case 4:
                        System.out.print("Enter book title to remove: ");
                        String titleToRemove = scan.nextLine();
                        removeBookFromLibrary(titleToRemove);
                        break;
                    case 5:
                        System.out.print("Enter client ID: ");
                        int id = scan.nextInt();
                        scan.nextLine(); // consumir quebra de linha
                        System.out.print("Enter client name: ");
                        String name = scan.nextLine();
                        System.out.print("Enter client CPF: ");
                        String cpfStr = scan.nextLine();
                        System.out.print("Enter client email: ");
                        String emailStr = scan.nextLine();
                        System.out.print("Enter client gender (M/F): ");
                        char gender = scan.nextLine().toUpperCase().charAt(0);
                        createClient(id, name, new CPF(cpfStr), new Email(emailStr), gender);
                        break;
                    case 6:
                        System.out.print("Enter book title to borrow: ");
                        String bookToBorrow = scan.nextLine();
                        System.out.print("Enter client name: ");
                        String clientNameToBorrow = scan.nextLine();
                        borrowBook(bookToBorrow, clientNameToBorrow);
                        break;
                    case 7:
                        System.out.print("Enter book title to return: ");
                        String bookToReturn = scan.nextLine();
                        System.out.print("Enter client name: ");
                        String clientName = scan.nextLine();
                        returnBookToLibrary(bookToReturn, clientName);
                        break;
                    case 0:
                        running = false;
                        System.out.println("Exiting Library System...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void listBooksFromLibrary(){
        bookManager.listBooksFromTheLibrary();
    }

    private void listClientsFromLibrary(){
        clientManager.listClientsFromTheLibrary();
    }

    private void removeBookFromLibrary(String title){
        bookManager.removeBookFromTheLibrary(title);
    }

    private void createClient(int id, String name, CPF cpf, Email email, char gender){
        clientManager.addClientInTheLibrary(id, name, cpf, email, gender);
    }

    private void createBook(String title, String author, String description, Date date){
        bookManager.insertBookInTheLibrary(title, author, description, date);
    }

    private void returnBookToLibrary(String title, String clientName){
        clientManager.returnBook(title, clientName);
    }

    private void borrowBook(String title, String clientName){
        Book book = bookManager.getBook(title);
        if(book == null)
            throw new IllegalArgumentException("Book doesn't exist.");
        clientManager.borrowerBookForClient(book, clientName);
    }
}
