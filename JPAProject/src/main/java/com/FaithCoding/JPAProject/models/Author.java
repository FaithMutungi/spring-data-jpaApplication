package com.FaithCoding.JPAProject.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder //used fin creating objects
@Entity
@Table(name = "Author_TBL")
public class Author extends BaseEntity {

    @Column(name = "f_name",
    length = 255)
    private String firstName;
    private  String lastName;
    @Column(unique = true, nullable = false)
    private  String email;
    private int age;

    @ManyToMany(mappedBy = "authors")  //a course is more dependent on the author/ a course cant exist without the author. so the course owns the relationship
    private List<Course> courses;


}


// an author can create multiple courses, and one course can be created by multiple authors- many-to-many relationship: creating list. undirectional relationship-the relationship is defined in one side. bidirectional-relationship defined in both sides