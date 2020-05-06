package com.example.book.controller.service;

import com.example.book.entities.Book;
import com.example.book.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    BooksRepository repository;


    public List<Book> findAllBooks() {
        List<Book> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public Book findBookById(Long id) {
        Optional<Book> opt = repository.findById(id);
        Book book;
        if (opt.isPresent()) {
            book = opt.get();
        } else {
            book = new Book();
        }
        return book;
    }

    public void saveBook(Book book) {
        repository.save(book);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
