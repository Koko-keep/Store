package com.example.datasaveapplication;

import org.litepal.crud.DataSupport;

public class Book extends DataSupport {
    private Integer id;
    private String author;
    private Double price;
    private String name;

    public Book() {
    }

    public Book(Integer id, String author, Double price, String name) {
        this.id = id;
        this.author = author;
        this.price = price;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
