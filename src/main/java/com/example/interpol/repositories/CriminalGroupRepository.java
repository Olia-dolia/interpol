package com.example.interpol.repositories;

import com.example.interpol.entities.Criminal;
import com.example.interpol.entities.CriminalGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CriminalGroupRepository extends JpaRepository<CriminalGroup, Long> {
}