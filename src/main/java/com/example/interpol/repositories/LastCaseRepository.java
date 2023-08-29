package com.example.interpol.repositories;

import com.example.interpol.entities.LastCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LastCaseRepository extends JpaRepository<LastCase, Long> {
}