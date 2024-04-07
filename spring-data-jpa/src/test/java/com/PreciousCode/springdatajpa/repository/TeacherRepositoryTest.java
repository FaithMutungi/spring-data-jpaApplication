package com.PreciousCode.springdatajpa.repository;

import com.PreciousCode.springdatajpa.entity.Course;
import com.PreciousCode.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {

    private final TeacherRepository teacherRepository;

    TeacherRepositoryTest(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    Course DBAcourse= Course.builder()
            .title("DBA")
            .credit(5)
            .build();
    Course CourseJava= Course.builder()
            .title("java")
            .credit(6)
            .build();



    @Test
    public  void  saveTeacher(){
        Teacher teacher= Teacher.builder()
                .firstName("jacob")
                .lastName("musembi")
               // .courses(List.of(CourseJava,DBAcourse))
                .build();
        teacherRepository.save(teacher);
    }



}