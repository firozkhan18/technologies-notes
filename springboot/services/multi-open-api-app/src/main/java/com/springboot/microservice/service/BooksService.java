package com.springboot.microservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springboot.microservice.model.BookInfo;

@Service
public class BooksService {
    private final Map<String, BookInfo> bookRepository = new HashMap<>();

    
    public BookInfo getById(String id) {
        return bookRepository.get(id);
    }

    
    public BookInfo add(BookInfo bookInfo) {
        String id = String.valueOf(bookRepository.size() + 1); // Simple ID generation
        bookRepository.put(id, bookInfo);
        return bookInfo;
    }

    
    public BookInfo updateStockById(String id, Integer quantity) {
        BookInfo book = bookRepository.get(id);
        if (book != null) {
            book.setQuantity(quantity);
        }
        return book;
    }
}

