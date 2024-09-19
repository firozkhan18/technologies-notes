package com.springboot.microservice.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservice.exception.BookIdMismatchException;
import com.springboot.microservice.exception.BookNotFoundException;
import com.springboot.microservice.model.BookEntity;
import com.springboot.microservice.repository.BookRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Books JPA", description = "Endpoints For Book Operations Using JPA")
@RestController()
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Operation(summary = "This is to fetch All the Books stored in Db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Fetched All the Books form Db",
            content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
            description = "NOt Available",
            content = @Content)
    })
    @GetMapping("book/")
    public List<BookEntity> allBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("book/")
    @ResponseStatus(HttpStatus.CREATED)
    public BookEntity create(@RequestBody BookEntity book)
    {
        return bookRepository.save(book);
    }

    @DeleteMapping("book/{id}")
    public void delete(@PathVariable long id)
    {
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }

    @PutMapping("book/{id}")
    public BookEntity updateBook(@RequestBody BookEntity book, @PathVariable Long id) {
        if (book.getId() != id) {
            throw new BookIdMismatchException();
        }
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        return bookRepository.save(book);
    }


    @GetMapping("book/{id}")
    public BookEntity find(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }


}
