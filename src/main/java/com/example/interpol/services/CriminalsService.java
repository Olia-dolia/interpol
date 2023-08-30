package com.example.interpol.services;

import com.example.interpol.entities.Criminal;
import com.example.interpol.repositories.CriminalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CriminalsService {
    private final CriminalRepository criminalRepository;

    public List<Criminal> getCriminals(){
        return criminalRepository.findAll();
    }
}
