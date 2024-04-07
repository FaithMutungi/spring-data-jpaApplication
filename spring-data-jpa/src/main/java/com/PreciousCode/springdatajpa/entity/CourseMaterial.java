package com.PreciousCode.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator( name = "course_material_sequence",
            sequenceName="course_material_sequence",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
    private Long CourseMaterialId;
    private String url;

    //coursematerial can't exist o it's own, must have a course , so define course here. a course has one course material, and a course materual belongs to one course- one to one mapping

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)//optional false ensures you cant save a course material without a course -course can't be null. //lazy fetch type won't include course values in the findall method
    @JoinColumn(name = "course_id", referencedColumnName = "courseId") //where the primary key lies
    private Course course;


}
