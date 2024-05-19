package com.example.projekt_sotel_nowak_sokolowska.data;

import com.example.projekt_sotel_nowak_sokolowska.model.Author;
import com.example.projekt_sotel_nowak_sokolowska.model.Book;
import com.example.projekt_sotel_nowak_sokolowska.model.Reader;
import com.example.projekt_sotel_nowak_sokolowska.repository.AuthorRepository;
import com.example.projekt_sotel_nowak_sokolowska.repository.BookRepository;
import com.example.projekt_sotel_nowak_sokolowska.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class SampleDataLoader implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;

    @Autowired
    public SampleDataLoader(AuthorRepository authorRepository, BookRepository bookRepository, ReaderRepository readerRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //String firstname, String lastname, LocalDate year
        Author author1 = new Author("Adam", "Mickiewicz", LocalDate.of(1798,12,13));
        Author author2 = new Author("Juliusz", "Słowacki", LocalDate.of(1809, 9, 4));
        Author author3 = new Author("Henryk", "Sienkiewicz", LocalDate.of(1846, 5, 5));
        Author author4 = new Author("Stanisław", "Lem", LocalDate.of(1921, 9, 12));
        Author author5 = new Author("Joanne", "Rowling", LocalDate.of(1965, 7, 31));

        authorRepository.saveAll(Arrays.asList(author1, author2, author3, author4, author5));

        //String title, Author author, String category, LocalDate year, boolean isAvailable
        Book book1 = new Book("Pan Tadeusz", author1, "poemat epicki", LocalDate.of(1834,6,26), true);
        Book book2 = new Book("Dziady", author1, "poemat dramatyczny", LocalDate.of(1822, 6, 26), true);
        Book book3 = new Book("Balladyna", author2, "dramat", LocalDate.of(1839, 9, 3), true);
        Book book4 = new Book("Quo Vadis", author3, "powieść historyczna", LocalDate.of(1896, 12, 26), true);
        Book book5 = new Book("Solaris", author4, "powieść science fiction", LocalDate.of(1961, 6, 1), true);
        Book book6 = new Book("Harry Potter and the Philosopher's Stone", author5, "powieść fantasy", LocalDate.of(1997, 6, 26), true);

        bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5, book6));

        //String firstname, String lastname, String email, Integer borrowedBooksCount, List<Book> borrowedBooks
        Reader reader1 = new Reader("Natalia", "Nowak", "natalianowak@gmail.com", 0, List.of(book1, book3, book6));
        Reader reader2 = new Reader("Jan", "Kowalski", "jankowalski@gmail.com", 0, Arrays.asList(book2, book4));
        Reader reader3 = new Reader("Anna", "Wiśniewska", "annawisniewska@gmail.com", 0, Arrays.asList(book1, book5));
        Reader reader4 = new Reader("Piotr", "Dąbrowski", "piotrdabrowski@gmail.com", 0, Arrays.asList(book3, book6));
        Reader reader5 = new Reader("Karolina", "Lis", "karolinalis@gmail.com", 0, Arrays.asList(book2, book4, book5));

        readerRepository.saveAll(Arrays.asList(reader1, reader2, reader3, reader4, reader5));
    }
}
