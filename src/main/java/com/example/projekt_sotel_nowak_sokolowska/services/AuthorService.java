package com.example.projekt_sotel_nowak_sokolowska.services;

import com.example.projekt_sotel_nowak_sokolowska.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
}
