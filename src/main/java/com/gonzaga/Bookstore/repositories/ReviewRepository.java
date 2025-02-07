package com.gonzaga.Bookstore.repositories;

import com.gonzaga.Bookstore.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {
}
