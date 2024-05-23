package com.example.projekt_sotel_nowak_sokolowska.controller;

import com.example.projekt_sotel_nowak_sokolowska.model.Book;
import com.example.projekt_sotel_nowak_sokolowska.model.BookRentals;
import com.example.projekt_sotel_nowak_sokolowska.repository.BookRentalsRepository;
import com.example.projekt_sotel_nowak_sokolowska.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class BookRentalController {

    @Autowired
    private BookRentalsRepository bookRentalsRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/all")
    public List<BookRentals> findAll(){
        return bookRentalsRepository.findAll();
    }

    @Transactional
    @PostMapping("/addRental")
    public ResponseEntity<BookRentals> addBookRentals(@RequestBody BookRentals br) {
        for (Book book : br.getBorrowedBooks()) {
            if (!book.isAvailable()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            }
        }

        for (Book book : br.getBorrowedBooks()) {
            bookRepository.updateAvailability(book.getId(), false);
        }

        BookRentals savedRental = bookRentalsRepository.save(br);
        return ResponseEntity.ok(savedRental);
    }

}
