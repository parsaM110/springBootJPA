package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {


    @Query("SELECT s from Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    //this is not sql but jpql => the sql is : select * from student where first_name = 'Maria' AND age>=21;
    @Query("SELECT s from Student s WHERE s.firstName = ?1 AND s.age >= ?2")
    List<Student> selectStudentWhereFirstNameAndAgeGreater(String firstName, Integer age);


    @Query(value = "select * from student where first_name = ?1 AND age>=?2",nativeQuery = true)
    List<Student> selectStudentWhereFirstNameAndAgeGreaterNative(String firstName, Integer age);

}
