package com.PreciousCode.springdatajpa.repository;

import com.PreciousCode.springdatajpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long>{
    public List <Student> findByFirstName(String firstName);
    public  List<Student> findByFirstNameContaining(String name);
    public  List <Student> findByLastNameNotNull (); //gets students where lastname is notnull
    public  List<Student> findByGuardianName(String guardianName);
    public  Student findByFirstNameAndLastName(String firstName, String lastName);
    //jpql
    @Query("select s from Student s where s.emailId=?1") //gets the values based on the class(Student) and not the table
    Student getStudentByEmailAddress(String emailId);

    //native query
@Query(
        value = " select * from tbl_student s where s.email_address=?1",
        nativeQuery = true
)
Student getStudentByEmailAddressNative(String emailId);

//native named param

    @Query(
            value = " select * from tbl_student s where s.email_address= :emailId",
            nativeQuery = true
    )

    Student getStudentByEmailAddressNativeNamedParams(@Param("emailId") String emailId);//the input val defines the correspondent column

 @Modifying
 @Transactional
    @Query(
            value = "update tbl_student  set first_name= ?1 where email_address=?2",
            nativeQuery = true
    )
    int updateStudentByEmailId( String firstName, String emailId);




}
