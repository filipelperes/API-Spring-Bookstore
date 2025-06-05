package com.bookstore.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.api.models.ReviewModel;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {

}
