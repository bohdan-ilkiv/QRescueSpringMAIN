package com.example.qrescue.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataRepository
        extends JpaRepository<Data, Long> {

    @Query("SELECT d FROM Data d WHERE d.email = ?1")
    Optional<Data> findStudentByEmail(String email);
}
