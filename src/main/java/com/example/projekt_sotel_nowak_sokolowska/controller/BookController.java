package com.example.projekt_sotel_nowak_sokolowska.controller;

import com.example.projekt_sotel_nowak_sokolowska.Error.ResourceNotFoundException;
import com.example.projekt_sotel_nowak_sokolowska.model.Author;
import com.example.projekt_sotel_nowak_sokolowska.model.Book;
import com.example.projekt_sotel_nowak_sokolowska.model.BookRentals;
import com.example.projekt_sotel_nowak_sokolowska.repository.BookRentalsRepository;
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

    @Autowired
    private BookRentalsRepository bookRentalsRepository;

    @GetMapping("/all")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));

        List<BookRentals> rentals = bookRentalsRepository.findByBorrowedBooksContains(book);
        for (BookRentals rental : rentals) {
            rental.getBorrowedBooks().remove(book);
            bookRentalsRepository.save(rental);
        }

        bookRepository.delete(book);

        return ResponseEntity.ok().body("Book deleted succesfully");
    }
    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long bookId,
                                               @RequestBody Book bookDetails) throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setCategory(bookDetails.getCategory());
        book.setReleaseDate(bookDetails.getReleaseDate());
        book.setAvailable(bookDetails.isAvailable());

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
