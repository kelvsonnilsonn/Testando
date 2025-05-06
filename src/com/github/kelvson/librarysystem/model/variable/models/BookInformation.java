package com.github.kelvson.librarysystem.model.variable.models;

import java.sql.Date;

public abstract class BookInformation {
    private final String title;
    private final String author;
    private final String description;
    private final Date creationDate;

    public BookInformation(String title, String author, String description, Date date){
        this.author = author;
        this.title = title;
        this.description = description;
        this.creationDate = date;
    }

    public Date getCreationDate() {
        return creationDate;
    }
    public String getAuthor() {
        return author;
    }
    public String getDescription() {
        return description;
    }
    public String getTitle() {
        return title;
    }
}
