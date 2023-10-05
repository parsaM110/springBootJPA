package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository,
            StudentIdCardRepository studentIdCardRepository
            ) {
        return args -> {

            Student student = new Student("Ali","Mohammad","ali@gmail.com",18);

//            studentRepository.save(student); -> you dont need to save the student otherwise you ran into error

            StudentIdCard studentIdCard = new StudentIdCard(
                    "123456789",
                    student);

            studentIdCardRepository.save(studentIdCard);

            studentIdCardRepository.findById(1l)
                    .ifPresent(System.out::println);



        };

    }


}
