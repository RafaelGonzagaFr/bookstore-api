package com.gonzaga.Bookstore.repositories;

import com.gonzaga.Bookstore.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {
}
