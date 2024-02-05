package com.example.qrescue.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class DataConfig {

    @Bean
    CommandLineRunner commandLineRunner(DataRepository repository){
        return args -> {
            Data bohdan = new Data(
                    "Bohdan",
                    "ilkivbo16@gmail.com",
                    LocalDate.of(2003, Month.MAY, 16)
            );

            Data vlada = new Data(
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
