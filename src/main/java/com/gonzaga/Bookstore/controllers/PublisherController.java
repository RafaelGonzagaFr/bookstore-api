package com.gonzaga.Bookstore.controllers;

import com.gonzaga.Bookstore.dtos.PublisherRecordDto;
import com.gonzaga.Bookstore.models.PublisherModel;
import com.gonzaga.Bookstore.services.PublisherService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/bookstore/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public ResponseEntity<List<PublisherModel>> getAllPublishers() {
        return ResponseEntity.status(HttpStatus.OK).body(publisherService.getAllPublishers());
    }

    @PostMapping
    public ResponseEntity<PublisherModel> savePublisher(@RequestBody PublisherRecordDto publisherRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(publisherService.savePublisher(publisherRecordDto));
    }
}
