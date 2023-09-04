package com.example.interpol.repositories;

import com.example.interpol.entities.LastCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LastCaseRepository extends JpaRepository<LastCase, Long> {
    LastCase findLastCaseByCaseName(String name);

    LastCase findByCaseName(String lastCase);
}