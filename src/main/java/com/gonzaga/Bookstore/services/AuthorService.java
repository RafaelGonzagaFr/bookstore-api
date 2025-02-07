package com.gonzaga.Bookstore.services;

import com.gonzaga.Bookstore.dtos.AuthorRecordDto;
import com.gonzaga.Bookstore.models.AuthorModel;
import com.gonzaga.Bookstore.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorModel> getAllAuthors(){
        return authorRepository.findAll();
    }

    public AuthorModel saveAuthor(AuthorRecordDto authorRecordDto){
        AuthorModel author = new AuthorModel();
        author.setName(authorRecordDto.name());

        return authorRepository.save(author);
    }
}
