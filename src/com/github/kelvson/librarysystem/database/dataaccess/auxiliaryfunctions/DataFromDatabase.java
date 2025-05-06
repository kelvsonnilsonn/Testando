package com.github.kelvson.librarysystem.database.dataaccess.auxiliaryfunctions;

import com.github.kelvson.librarysystem.model.Book;
import com.github.kelvson.librarysystem.model.Client;

import java.util.List;

public record DataFromDatabase(List<Book> books, List<Client> clients) {
}
