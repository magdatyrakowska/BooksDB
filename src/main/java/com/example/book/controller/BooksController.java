package com.example.book.controller;


import com.example.book.controller.service.BooksService;
import com.example.book.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BooksService service;

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("books", service.findAllBooks());
        return "books";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("bookEdit", new Book());
        return "bookEdit";
    }

    @GetMapping("/edit")
    public String editBook(@RequestParam Long id, Model model) {
        Book book = service.findBookById(id);
        model.addAttribute("bookEdit", book);
        return "bookEdit";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("bookEdit") Book book) {
        service.saveBook(book);
        return"redirect:/books";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam Long id) {
        service.deleteBook(id);
        return "redirect:/books";
    }

}
