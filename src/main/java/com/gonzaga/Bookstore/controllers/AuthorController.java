package com.gonzaga.Bookstore.controllers;

import com.gonzaga.Bookstore.dtos.AuthorRecordDto;
import com.gonzaga.Bookstore.models.AuthorModel;
import com.gonzaga.Bookstore.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<AuthorModel>> getAllAuthors(){
        return ResponseEntity.status(HttpStatus.OK).body(authorService.getAllAuthors());
    }

    @PostMapping
    public ResponseEntity<AuthorModel> saveAuthor(@RequestBody AuthorRecordDto authorRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.saveAuthor(authorRecordDto));
    }
}
