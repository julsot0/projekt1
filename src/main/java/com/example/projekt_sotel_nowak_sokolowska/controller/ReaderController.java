package com.example.projekt_sotel_nowak_sokolowska.controller;

import com.example.projekt_sotel_nowak_sokolowska.model.Author;
import com.example.projekt_sotel_nowak_sokolowska.model.Reader;
import com.example.projekt_sotel_nowak_sokolowska.repository.AuthorRepository;
import com.example.projekt_sotel_nowak_sokolowska.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/readers")
public class ReaderController {

    @Autowired
    private ReaderRepository readerRepository;

    @GetMapping("/all")
    private List<Reader> findAll(){
        return readerRepository.findAll();
    }
}
