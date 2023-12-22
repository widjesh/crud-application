package com.example.CrudApplication.controllers;

import com.example.CrudApplication.models.Book;
import com.example.CrudApplication.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/book")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAllBooks(){
        List<Book> allBooks = bookService.getAllBooks();
        return allBooks;
    }

    @PostMapping
    public Book createBook(@RequestBody Book incomingBook){
        Book savedBook = bookService.createBook(incomingBook);
        return savedBook;
    }

    @PutMapping
    public Book updateBook(@RequestBody Book bookToBeUpdated){
        Book updatedBook = bookService.updateBook(bookToBeUpdated);
        return updatedBook;
    }

}
