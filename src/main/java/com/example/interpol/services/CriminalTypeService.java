package com.example.interpol.services;

import com.example.interpol.entities.CriminalType;
import com.example.interpol.repositories.CriminalTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CriminalTypeService {

    private final CriminalTypeRepository criminalTypeRepository;

    public List<CriminalType> findAll() {
        return criminalTypeRepository.findAll();
    }
}
