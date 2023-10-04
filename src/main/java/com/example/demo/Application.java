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

            System.out.println("\u001B[33m" + "Number of students: " + "\u001B[0m");
            System.out.println("\u001B[34m" + studentRepository.count()+ "\u001B[0m");

            studentRepository.findById(2L).ifPresentOrElse(
//                    student -> {
//                        System.out.println(student);
//                    }
                    //todo : instead of lambda we use expression lambda :|
                    System.out::println
                    , () -> System.out.println("Student with ID 2 not found")
//                    {
//                System.out.println("Student with ID 2 not found");
//            }
                    //todo : instead of {} we use only the expression but without ; at end
            );

            studentRepository.findById(3L).ifPresentOrElse(
                    System.out::println
                    , () -> System.out.println("Student with ID 3 not found"));

            System.out.println("\u001B[33m" + "select all student: " + "\u001B[0m");
            List<Student> students = studentRepository.findAll();
            students.forEach(System.out::println);

            System.out.println("\u001B[33m" + "delete maria  " + "\u001B[0m");
            studentRepository.deleteById(1L);

            System.out.println("\u001B[33m" + "Number of students  " + "\u001B[0m");
            System.out.println( "\u001B[34m" + studentRepository.count()+ "\u001B[0m");

        };
    }

}
