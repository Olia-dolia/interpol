package com.example.interpol.repositories;

import com.example.interpol.entities.Criminal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriminalRepository extends JpaRepository<Criminal, Long> {
    Criminal findAllById(long l);
}