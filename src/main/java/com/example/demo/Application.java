package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
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

            Student student = new Student("Ali", "Mohammad", "ali@gmail.com", 18);

            student.addBook(
                    new Book("Clean Code", LocalDateTime.now().minusDays(4)));

            student.addBook(
                    new Book("Think and Grow Rich", LocalDateTime.now().minusDays(4)));

            student.addBook(
                    new Book("Spring Data JPA", LocalDateTime.now().minusYears(1)));

            StudentIdCard studentIdCard = new StudentIdCard(
                    "123456789",
                    student);

            student.setStudentIdCard(studentIdCard);

            student.addEnrolment(new Enrolment(
                    new EnrolmentId(1L,1L),
                    student,new Course("Computer Science",
                    "IT")
            ));

            student.addEnrolment(new Enrolment(
                    new EnrolmentId(1L,2L),
                    student,
                    new Course("Amigosocde Spring DATA JPA","IT")
            ));

//            student.enrolToCourse(new Course("Computer Science","IT"));
//
//            student.enrolToCourse(new Course("Amigosocde Spring DATA JPA","IT"));

            studentRepository.save(student);

//            studentIdCardRepository.save(studentIdCard);


            studentRepository.findById(1L)
                    .ifPresent(s -> {
                        System.out.println("\u001B[33m" + "fetch books Lazy..." + "\u001B[0m");
                        List<Book> books = student.getBooks();
                        books.forEach(book -> {
                            System.out.println(s.getFirstName() + " borrowed" + book.getBookName());
                        });

                    });
        };

    }


}
