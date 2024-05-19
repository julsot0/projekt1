package com.example.projekt_sotel_nowak_sokolowska.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name="author_id", nullable = true)
    private Author author;

    private String category;

    private LocalDate releaseDate;

    private Boolean isAvailable;

    public Book() { }
    public Book(String title, Author author, String category, LocalDate releaseDate, Boolean isAvailable){
        this.title = title;
        this.author = author;
        this.category = category;
        this.releaseDate = releaseDate;
        this.isAvailable = isAvailable;
    }
}
