package com.example.projekt_sotel_nowak_sokolowska.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private Integer borrowedBooksCount;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE})
    @JoinTable(
            name = "reader_books",
            joinColumns = @JoinColumn(name = "reader_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> borrowedBooks;

    public Reader() { }
    public Reader(String firstname, String lastname, String email, Integer borrowedBooksCount, List<Book> borrowedBooks)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.borrowedBooksCount = borrowedBooksCount;
        this.borrowedBooks = borrowedBooks;
    }
}
