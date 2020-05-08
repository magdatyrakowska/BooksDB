package com.example.book.controller;


import com.example.book.controller.service.BooksService;
import com.example.book.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/books")
public class BooksController {

    BooksService service;

    @Autowired
    public BooksController(BooksService service){
        this.service = service;
    }

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
    public String saveBook(@Valid @ModelAttribute("bookEdit") Book book, Errors errors) {
        if(errors.hasErrors()) {
            return "bookEdit";
        } else {
            service.saveBook(book);
            return "redirect:/books";
        }
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam Long id) {
        service.deleteBook(id);
        return "redirect:/books";
    }

}
