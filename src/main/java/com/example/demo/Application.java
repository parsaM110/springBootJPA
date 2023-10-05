package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
//            Sort sort = Sort.by(Sort.Direction.DESC, "firstName");
            Sort sort = Sort.by( "firstName").ascending().and(Sort.by("age").descending());
            studentRepository.findAll(sort)
                    .forEach(student -> System.out.println(student.getFirstName() + " " + student.getAge()));

        };

    }

}
