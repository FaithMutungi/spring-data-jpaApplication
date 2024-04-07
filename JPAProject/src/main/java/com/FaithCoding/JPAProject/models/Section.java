package com.FaithCoding.JPAProject.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Section extends BaseEntity {

    private String name;
    private  int sectionOrder;

    //many sections belong to one course
    @ManyToOne
    @JoinColumn(name = "course_id")

    private Course course;

    //a section has a list of lectures
    @OneToMany(mappedBy = "section")

    private List<Lecture> lectures;




}


