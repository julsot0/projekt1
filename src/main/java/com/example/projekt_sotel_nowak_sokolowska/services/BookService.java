package com.example.projekt_sotel_nowak_sokolowska.services;

import com.example.projekt_sotel_nowak_sokolowska.model.Author;
import com.example.projekt_sotel_nowak_sokolowska.model.Book;
import com.example.projekt_sotel_nowak_sokolowska.model.Reader;
import com.example.projekt_sotel_nowak_sokolowska.repository.BookRepository;
import com.example.projekt_sotel_nowak_sokolowska.repository.ReaderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /*
    @Transactional
    public void deleteAuthorAndSetNullForBooks(Long authorId) {
        Author authorToDelete = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Autor o podanym identyfikatorze nie istnieje"));

        List<Book> books = bookRepository.findByAuthorId(authorId);

        for (Book book : books) {
            book.setAuthor(null);
            bookRepository.save(book);
        }
        authorRepository.delete(authorToDelete);
    }
     */
}
