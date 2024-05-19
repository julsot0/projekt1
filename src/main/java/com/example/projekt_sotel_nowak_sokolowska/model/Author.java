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
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private LocalDate birthYear;

//    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
//    private List<Book> writtenBooks;

    public Author() { }
    public Author(String firstname, String lastname, LocalDate birthYear){
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthYear = birthYear;
    }
}
