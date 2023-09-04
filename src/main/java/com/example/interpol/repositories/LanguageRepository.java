package com.example.interpol.repositories;

import com.example.interpol.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    Language findByLanguage(String en);
}
