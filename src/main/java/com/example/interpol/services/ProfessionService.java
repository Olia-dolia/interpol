package com.example.interpol.services;

import com.example.interpol.entities.Profession;
import com.example.interpol.repositories.ProfessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProfessionService {

    private final ProfessionRepository professionRepository;

    public List<Profession> findAll(){
        return professionRepository.findAll();
    }

}
