package com.cognizant;

import com.cognizant.entity.Student;
import com.cognizant.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StudentRepository repo) {
        return args -> {
            // save students
            repo.save(new Student("Abhishek", "abhishek@gmail.com"));
            repo.save(new Student("Priya", "priya@gmail.com"));
            repo.save(new Student("Rahul", "rahul@gmail.com"));

            // fetch all
            System.out.println("All students:");
            repo.findAll().forEach(System.out::println);

            // fetch by id
            System.out.println("\nStudent with id 1: " + repo.findById(1));

            // count
            System.out.println("Total students: " + repo.count());
        };
    }
}
