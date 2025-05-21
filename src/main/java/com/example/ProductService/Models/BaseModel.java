package com.example.ProductService.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // Now spring boot will tell to db to generate id automatically
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isDeleted;
}
