package com.lancefallon.reactive.springreactivedemo.models;

import java.util.List;

public class Book {

    private Integer id;
    private String ISBN;
    private String name;
    private List<Author> authors;

    public Book() {
    }

    public Book(Integer id, String ISBN, String name, List<Author> authors) {
        this.id = id;
        this.ISBN = ISBN;
        this.name = name;
        this.authors = authors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", authors=" + authors +
                '}';
    }
}
