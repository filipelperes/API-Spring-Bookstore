package com.bookstore.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.api.models.AuthorModel;

public interface AuthorRepositoy extends JpaRepository<AuthorModel, UUID> {
}
