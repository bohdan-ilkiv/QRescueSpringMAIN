package com.example.qrescue.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student bohdan = new Student(
                    "Bohdan",
                    "ilkivbo16@gmail.com",
                    LocalDate.of(2003, Month.MAY, 16)
            );

            Student vlada = new Student(
                    "Vlada",
                    "vlada@gmail.com",
                    LocalDate.of(2003, Month.JULY, 6)
            );

            repository.saveAll(
                    List.of(bohdan, vlada)
            );
        };
    }
}
