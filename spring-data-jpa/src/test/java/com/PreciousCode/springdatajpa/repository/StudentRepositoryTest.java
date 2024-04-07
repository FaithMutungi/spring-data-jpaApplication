package com.PreciousCode.springdatajpa.repository;

import com.PreciousCode.springdatajpa.entity.Guardian;
import com.PreciousCode.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private  StudentRepository studentRepository;



    @Test
    public  void saveStudent(){
        Student student= Student.builder()
                .emailId("preccy@gmail.com").firstName("precious").lastName("mutungi")//.guardianName("benedict")
                       // .guardianEmail("ben@gmail.com").guardianMobile("718045752")
                .build();
        studentRepository.save(student);

    }
    @Test
    public  void saveStudentWithGuardian(){
        Guardian guardian= Guardian.builder()
                .email("kisoi@gmail.com")
                .name("musembi")
                .mobile("748368870")
                .build();

        Student student= Student.builder()
                .firstName("jacob")
                .emailId("kisoijacob@gmail.com")
                .lastName("kisoi")
                .guardian(guardian)
                .build();
        studentRepository.save(student);


    }
  @Test
    public void printAllStudent(){

      List<Student> studentList= studentRepository.findAll();

      System.out.println("studentList = " + studentList);


    }
    @Test

    public  void printStudentByFirstName (){
        List<Student> students= studentRepository.findByFirstName("jacob");
        System.out.println("students = "+ students);

    }

    @Test

    public  void printStudentByFirstNameContaining (){
        List<Student> students= studentRepository.findByFirstNameContaining("pre");
        System.out.println("students = "+ students);

    }

    @Test
    public void printStudentByGuardianName(){
        List <Student> students =studentRepository.findByGuardianName("musembi");
        System.out.println("students = " + students);

    }
    @Test

    public  void  printStudentByEmailAddress(){

        Student student = studentRepository.getStudentByEmailAddress("preccy@gmail.com");
        System.out.println("student = " + student);
    }
    @Test
    public void printStudentByEmailAddressNative(){
        Student student=studentRepository.getStudentByEmailAddressNative("preccy@gmail.com");
        System.out.println("student = " + student);

    }
    @Test
    public  void printStudentByNativeNamedParam(){
        Student student= studentRepository.getStudentByEmailAddressNativeNamedParams("preccy@gmail.com");
        System.out.println("student = " + student);


    }
    @Test

    public  void  updateStudentNameByEmailId(){
        studentRepository.updateStudentByEmailId("Faith", "preccy@gmail.com");

    }





    }

