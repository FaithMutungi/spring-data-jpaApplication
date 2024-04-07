package com.FaithCoding.JPAProject.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
public class Course extends BaseEntity {

    private String name;
    private  String description;

    @ManyToMany
    @JoinTable(
            name = "authors-courses",
            joinColumns = {
                    @JoinColumn(name = "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Author> authors;
    //a course has a list of sections
    @OneToMany(mappedBy = "course")
    List <Section> sections;
}



// a course has one or many sections, and one section belongs to only one course- one to many relationship. so we need a foreign key course id, associated with the section class
