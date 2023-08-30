package com.example.interpol.repositories;

import com.example.interpol.entities.Criminal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CriminalRepository extends JpaRepository<Criminal, Long> {
}