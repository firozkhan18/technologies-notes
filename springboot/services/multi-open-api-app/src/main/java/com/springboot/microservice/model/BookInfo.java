package com.springboot.microservice.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookInfo {
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Author cannot be blank")
    private String author;

    @Min(value = 0, message = "Quantity must be at least 0")
    private Integer quantity;

    public void setQuantity(Integer quantity) {
        if (quantity != null && quantity < 0) {
            throw new IllegalArgumentException("Quantity must be at least 0");
        }
        this.quantity = quantity;
    }
}

