package com.gonzaga.Bookstore.repositories;

import com.gonzaga.Bookstore.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<PublisherModel, UUID> {
}
