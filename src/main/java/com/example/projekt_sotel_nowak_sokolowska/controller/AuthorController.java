package com.example.projekt_sotel_nowak_sokolowska.controller;

import com.example.projekt_sotel_nowak_sokolowska.Error.ResourceNotFoundException;
import com.example.projekt_sotel_nowak_sokolowska.model.Author;
import com.example.projekt_sotel_nowak_sokolowska.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/all")
    private List<Author> findAll(){
        return authorRepository.findAll();
    }

    @PostMapping("/addAuthor")
    public Author addAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @DeleteMapping("/deleteAuthor/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable(value = "id") Long authorId)
            throws ResourceNotFoundException {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found for this id :: " + authorId));

        authorRepository.delete(author);
        return ResponseEntity.ok().body("Author deleted succesfully");
    }

    @PutMapping("/updateAuthor/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable(value = "id") Long authorId,
                                             @RequestBody Author authorDetails) throws ResourceNotFoundException {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found for this id :: " + authorId));

        author.setFirstname(authorDetails.getFirstname());
        author.setLastname(authorDetails.getLastname());
        author.setBirthYear(authorDetails.getBirthYear());
        //author.setWrittenBooks(authorDetails.getWrittenBooks());

        final Author updatedAuthor = authorRepository.save(author);
        return ResponseEntity.ok(updatedAuthor);
    }

    /*
    {
        "firstname": "Jacob",
            "lastname": "Bond",
            "birthYear": "1999-10-29"
    }
    */

}
