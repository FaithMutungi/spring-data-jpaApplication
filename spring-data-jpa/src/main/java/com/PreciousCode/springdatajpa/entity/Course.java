package com.PreciousCode.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Course {
    @Id
    @SequenceGenerator( name = "course_sequence",
    sequenceName="course_sequence",
    allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private  Long courseId;
    private String title;
    private Integer credit;


    @OneToOne(mappedBy = "course") //one to one bidirectional mapping. helps find both course and course material values in find all metheod
    private  CourseMaterial courseMaterial;

    @ManyToOne (cascade = CascadeType.ALL) //multiple courses can be taught by one teacher. preferably define many to one, instead of one to many
    @JoinColumn( name = "teacher_id",
    referencedColumnName = "teacherId")
    private Teacher teacher;

@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(
        name = "student_course_mapping",
        joinColumns = @JoinColumn(name = "course_id",
        referencedColumnName = "courseId"),
        inverseJoinColumns = @JoinColumn(name = "student_id",
        referencedColumnName = "studentId")

)
    private List<Student> students;

public void addStudent(Student student){
    if (students == null) students= new ArrayList<>();
    students.add(student);

}
}
