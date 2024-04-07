package com.FaithCoding.JPAProject.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder //use this with all the enties extending the base entity


public class BaseEntity {

    @Id
    @GeneratedValue
    private Integer id; //use wrapper instead of primitive coz by default integer is zero, rather than null(default for int)

    private LocalDateTime createdAt;
    private  LocalDateTime lastModifiedAt;
    private String createdBy;
    private  String lastModifiedBy;
}
