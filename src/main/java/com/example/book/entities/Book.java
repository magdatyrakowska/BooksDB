package com.example.book.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String published;

    public Book(Long id, String title, String author, String published) {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.published = published;
    }

    public Book() {
    }
}
