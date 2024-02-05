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
            Data kleparivska35 = new Data(
                    1L,
                    200L,
                    2L
            );

            Data kleparivska22 = new Data(
                    2L,
                    222L,
                    6L
            );

            repository.saveAll(
                    List.of(kleparivska35, kleparivska22)
            );
        };
    }
}
