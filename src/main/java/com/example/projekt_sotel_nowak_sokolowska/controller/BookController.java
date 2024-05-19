package com.example.projekt_sotel_nowak_sokolowska.controller;

import com.example.projekt_sotel_nowak_sokolowska.Error.ResourceNotFoundException;
import com.example.projekt_sotel_nowak_sokolowska.model.Author;
import com.example.projekt_sotel_nowak_sokolowska.model.Book;
import com.example.projekt_sotel_nowak_sokolowska.repository.BookRepository;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/all")
    private List<Book> findAll(){
        return bookRepository.findAll();
    }

    @PostMapping("/Book")
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/Book/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "id") Long bookId)
            throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));

        bookRepository.delete(book);
        return ResponseEntity.ok().body("Book deleted succesfully");
    }

    @PutMapping("/Book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long bookId,
                                               @RequestBody Book bookDetails) throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setCategory(bookDetails.getCategory());
        book.setReleaseDate(bookDetails.getReleaseDate());
        book.setIsAvailable(bookDetails.getIsAvailable());

        final Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }

    /*
    {
        "title": "Jacob Bond",
            "author": {
        "id": 1
    },
        "category": "moja kategoria",
            "releaseDate": "1985-10-03",
            "isAvailable": true
    }
     */
}
