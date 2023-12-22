package com.example.CrudApplication.services.serviceimpls;

import com.example.CrudApplication.models.Book;
import com.example.CrudApplication.repositories.BookRepository;
import com.example.CrudApplication.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        List<Book> allBooks = bookRepository.findAll();
        return allBooks;
    }


    public Book createBook(Book incomingBook){
        Book savedBook = bookRepository.save(incomingBook);
        return savedBook;
    }

    public Book updateBook(Book toBeUpdatedBook) {
        Long id = toBeUpdatedBook.getId();
        Optional<Book> foundBookOptional = bookRepository.findById(id);
        if(foundBookOptional.isPresent()){
            Book bookFound = foundBookOptional.get();
            bookFound.setTitle(toBeUpdatedBook.getTitle());
            bookFound.setAuthor(toBeUpdatedBook.getAuthor());
            return bookFound;
        }else{
            return null;
        }
    }


}
