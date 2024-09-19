package com.springboot.microservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BookEntity {

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;

	    @Column
	    private String title;

	    @Column
	    private String author;

	    @Column
	    private String price;

		public Long getId() {
			// TODO Auto-generated method stub
			return id;
		}
}
