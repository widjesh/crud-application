package com.example.CrudApplication.services;

import com.example.CrudApplication.models.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book incomingBook);
    List<Book> getAllBooks();
    Book updateBook(Book toBeUpdatedBook);

}
