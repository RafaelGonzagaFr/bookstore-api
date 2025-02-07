package com.gonzaga.Bookstore.services;

import com.gonzaga.Bookstore.dtos.BookRecordDto;
import com.gonzaga.Bookstore.models.AuthorModel;
import com.gonzaga.Bookstore.models.BookModel;
import com.gonzaga.Bookstore.models.ReviewModel;
import com.gonzaga.Bookstore.repositories.AuthorRepository;
import com.gonzaga.Bookstore.repositories.BookRepository;
import com.gonzaga.Bookstore.repositories.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    public List<BookModel> getAllBooks(){
        return bookRepository.findAll();
    }

    @Transactional
    public BookModel saveBook(BookRecordDto bookRecordDto) {
        BookModel book = new BookModel();
        book.setTitle(bookRecordDto.title());
        book.setPublisher(publisherRepository.findById(bookRecordDto.publisherId()).get());
        book.setAuthors(new HashSet<>(authorRepository.findAllById(bookRecordDto.authorIds())));

        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setComment(bookRecordDto.reviewComment());
        reviewModel.setBook(book);
        book.setReview((reviewModel));

        return bookRepository.save(book);
    }
}
