package com.example.interpol.repositories;

import com.example.interpol.entities.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
    Optional<Profession> findById(Long id);
}