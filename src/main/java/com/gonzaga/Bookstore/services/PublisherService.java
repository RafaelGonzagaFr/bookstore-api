package com.gonzaga.Bookstore.services;

import com.gonzaga.Bookstore.dtos.PublisherRecordDto;
import com.gonzaga.Bookstore.models.PublisherModel;
import com.gonzaga.Bookstore.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<PublisherModel> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public PublisherModel savePublisher(PublisherRecordDto publisherRecordDto){
        PublisherModel publisher = new PublisherModel();
        publisher.setName(publisherRecordDto.name());
        return publisherRepository.save(publisher);
    }
}
