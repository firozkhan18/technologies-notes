package com.springboot.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.springboot.microservice.model.BookEntity;

@Service
public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
