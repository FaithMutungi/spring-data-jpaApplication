package com.PreciousCode.springdatajpa.repository;

import com.PreciousCode.springdatajpa.entity.Course;
import com.PreciousCode.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test; 
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class CourseMaterialRepositoryTest {

    private final CourseMaterialRepository courseMaterialRepository;

    CourseMaterialRepositoryTest(CourseMaterialRepository courseMaterialRepository) {
        this.courseMaterialRepository = courseMaterialRepository;
    }

    @Test
    public void saveCourseMaterial(){

        Course course=Course.builder()
                .title("calculus")
                .credit(4)
                .build();

        CourseMaterial courseMaterial= CourseMaterial.builder()
                .url("www.tutorials point.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }
@Test
    public  void printAllCourseMaterials(){
    List<CourseMaterial> courseMaterials= courseMaterialRepository.findAll();
    System.out.println("course Materials= " + courseMaterials);


    }


}