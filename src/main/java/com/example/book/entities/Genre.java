package com.example.book.entities;

public enum Genre {
    FICTION("fiction"),
    NON_FICTION("non-fiction"),
    POPULAR_SCIENCE("popular science"),
    CHILDREN("children"),
    COMICS("comics"),
    OTHER("other");

    private final String name;

    Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
