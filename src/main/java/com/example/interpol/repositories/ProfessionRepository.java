package com.example.interpol.repositories;

import com.example.interpol.entities.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
}