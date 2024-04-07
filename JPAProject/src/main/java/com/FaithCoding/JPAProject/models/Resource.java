package com.FaithCoding.JPAProject.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@DiscriminatorColumn(name = "resource_type")
public class Resource {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private  int size;
    private String url;

    //one lecture has only one resource, and one resource belongs only to one lecture- one-to-one relationship

    @OneToOne
    @JoinColumn(name = "lecture_id")
   private  Lecture lecture;


}
