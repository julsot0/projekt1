package com.example.projekt_sotel_nowak_sokolowska.repository;

import com.example.projekt_sotel_nowak_sokolowska.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
