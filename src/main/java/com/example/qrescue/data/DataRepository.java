package com.example.qrescue.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataRepository
        extends JpaRepository<Data, Long> {

    @Query("SELECT d FROM Data d WHERE d.id_building = ?1")
    Optional<Data> findDataById(Long id_building);
}
