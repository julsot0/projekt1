package com.example.projekt_sotel_nowak_sokolowska.services;

import com.example.projekt_sotel_nowak_sokolowska.model.Book;
import com.example.projekt_sotel_nowak_sokolowska.model.Reader;
import com.example.projekt_sotel_nowak_sokolowska.repository.BookRepository;
import com.example.projekt_sotel_nowak_sokolowska.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final ReaderRepository readerRepository;

    public BookService(BookRepository bookRepository, ReaderRepository readerRepository) {
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
    }
}
