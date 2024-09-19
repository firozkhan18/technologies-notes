package com.springboot.microservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservice.model.BookInfo;
import com.springboot.microservice.service.BooksService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Tag(name = "Books", description = "Endpoints for book operations")
@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
@Validated
public class BookRestController {

	@Autowired
    private BooksService bookService;

//	public BookRestController(BookService bookService) {
//		this.bookService = bookService;
//	}

    @Operation(summary = "Get book info", description = "Get book info by id", tags = { "Books" })
    //@Parameter(in = ParameterIn.HEADER, description = "Authorization token", name = "X-Auth-Token", content = @Content(schema = @Schema(type = "string")))
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = BookInfo.class))),
        @ApiResponse(responseCode = "400", description = "Book with given id does not exist.", content = @Content)
    })
    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity<BookInfo> getBookById(@PathVariable(required = true) @NotBlank String id) {
        return ResponseEntity.ok().body(bookService.getById(id));
    }

    @Operation(summary = "Insert book", description = "Insert a new book", tags = { "Books" })
    @Parameter(in = ParameterIn.HEADER, description = "Authorization token", name = "X-Auth-Token", content = @Content(schema = @Schema(type = "string")))
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = BookInfo.class)))
    })
    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<BookInfo> addBook(@Valid @RequestBody BookInfo bookInfo) {
        return ResponseEntity.ok().body(bookService.add(bookInfo));
    }

    @Operation(summary = "Update book stock", description = "Update book stock by id", tags = { "Books" })
    @Parameter(in = ParameterIn.HEADER, description = "Authorization token", name = "X-Auth-Token", content = @Content(schema = @Schema(type = "string")))
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = BookInfo.class))),
        @ApiResponse(responseCode = "400", description = "Book with given id does not exist.", content = @Content)
    })
    @PatchMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<BookInfo> updateStockById(@PathVariable(required = true) @NotBlank String id,
            @Valid @RequestBody @NotNull @Min(value = 0) Integer quantity) {
        return ResponseEntity.ok().body(bookService.updateStockById(id, quantity));
    }
}
