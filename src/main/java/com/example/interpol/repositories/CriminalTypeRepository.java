package com.example.interpol.repositories;

import com.example.interpol.entities.CriminalType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriminalTypeRepository extends JpaRepository<CriminalType, Long> {
    CriminalType findByNameType(String name);
}