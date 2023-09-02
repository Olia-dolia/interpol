package com.example.interpol.services;

import com.example.interpol.entities.Language;
import com.example.interpol.repositories.LanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    public List<Language> findAll(){
        return languageRepository.findAll();
    }
}
