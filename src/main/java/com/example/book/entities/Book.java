package com.example.book.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotBlank(message = "Book must have a title.")
    private String title;
    @NotBlank(message = "Book must have an author.")
    private String author;
    private Genre genre;
    @Pattern(regexp="^[12][0-9]{3}$",
            message="Year must be composed of 4 numbers.")
    private String published;

    public Book() {
        super();
    }
}
