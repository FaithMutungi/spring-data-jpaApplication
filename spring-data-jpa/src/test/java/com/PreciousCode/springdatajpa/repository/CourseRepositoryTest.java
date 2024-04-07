package com.PreciousCode.springdatajpa.repository;

import com.PreciousCode.springdatajpa.entity.Course;
import com.PreciousCode.springdatajpa.entity.Student;
import com.PreciousCode.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
@Test
    public void printCourses(){

    List<Course> courses= courseRepository.findAll();
    System.out.println("courses= " + courses);



    }
@Test
    public void saveCourseWithTeacherObject(){
    Teacher teacher= Teacher.builder()
            .firstName("precious")
            .lastName("mutungi")
            .build();

    Course course= Course.builder()
            .title("Python")
            .credit(5)
            .teacher(teacher)
            .build();
    courseRepository.save(course);

    }

    @Test
    public  void findAllPagination(){
        Pageable secondPageWithTwoRecords= PageRequest.of(1,2);

            Pageable firstPageWithThreeRecords= PageRequest.of(0,3);


        List<Course> courses =courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements= courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages=courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();


        System.out.println("courses = " + courses);
        System.out.println("total elements: " + totalElements);
        System.out.println("total pages: " + totalPages);


    }
    /*@Test
    public void findAllSorting(){
   Pageable sortByTitle= PageRequest.of(0, 2, Sort.by("title"));

    Pageable sortByCreditDisc= PageRequest.of(1,2, Sort.by("credit").descending());

    Pageable sortByTitleAndCreditInDisc= PageRequest.of(0,2, Sort.by("CourseTitle").descending().and(Sort.by("credit")));

    List<Course> courses=courseRepository.findAll(sortByCreditDisc).getContent();
        System.out.println("courses: " + courses);


    }*/
    /*@Test
    public void printFindByTitleContaining (){
        Pageable firstPageTenRecords= PageRequest.of(0, 10);
        List<Course> courses=courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();
        System.out.println("courses =" + courses);
    }*/

    @Test
    public void saveCourseWithStudentAndTeacher(){

    Teacher teacher= Teacher.builder()
            .firstName("stella")
            .lastName("mwende")
            .build();

        Student student= Student.builder()
                .firstName("malonza")
                .lastName("mutungi")
                .emailId("deno@gmail.com")

                .build();

    Course course= Course.builder()
            .title("AI")
            .credit(12)
            .teacher(teacher)
            .build();

    course.addStudent(student);
    courseRepository.save(course);


    }
   

}