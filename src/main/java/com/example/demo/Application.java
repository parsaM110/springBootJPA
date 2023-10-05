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

            studentIdCardRepository.save(studentIdCard);

            /*studentRepository.findById(1L)
                    .ifPresent(System.out::println);*/

            //fetch type is lazy in default one2many and many2one so for accessing books you have to :

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
