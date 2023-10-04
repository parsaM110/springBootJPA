package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student maria = new Student("Maria",
                    "Jones",
                    "maria.jones@amigoscode.edu",
                    21);

            Student ahmed = new Student("Ahmed",
                    "Ali",
                    "ahmed.ali@amigoscode.edu",
                    18);

            System.out.println("\u001B[33m" + "Adding maria and Ahmad" + "\u001B[0m");
            studentRepository.saveAll(List.of(maria, ahmed));

            studentRepository.findStudentByEmail("ahmed.ali@amigoscode.edu")
                    .ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Student with email ahmed.ali@amigoscode.edu not found"));

        };
    }

}
