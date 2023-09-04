package com.example.interpol.repositories;

import com.example.interpol.entities.Criminal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CriminalRepository extends JpaRepository<Criminal, Long> {
    List<Criminal> findCriminalsByStatusStatus(String status);
    Set<Criminal> findCriminalByCriminalGroupId(Long id);
}