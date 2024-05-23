package com.example.projekt_sotel_nowak_sokolowska.repository;

import com.example.projekt_sotel_nowak_sokolowska.model.Author;
import com.example.projekt_sotel_nowak_sokolowska.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorId(Long authorId);

    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.available = :isAvailable WHERE b.id = :bookId")
    void updateAvailability(@Param("bookId") Long bookId, @Param("isAvailable") boolean isAvailable);
}
