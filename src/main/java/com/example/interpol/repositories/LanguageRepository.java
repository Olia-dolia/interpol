package com.example.interpol.repositories;

import com.example.interpol.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}