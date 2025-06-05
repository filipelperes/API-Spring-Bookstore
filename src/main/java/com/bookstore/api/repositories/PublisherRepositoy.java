package com.bookstore.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.api.models.PublisherModel;

public interface PublisherRepositoy extends JpaRepository<PublisherModel, UUID> {
}
