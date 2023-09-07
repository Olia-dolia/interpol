package com.example.interpol.services;

import com.example.interpol.entities.LastCase;
import com.example.interpol.repositories.LastCaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LastCaseService {

    private final LastCaseRepository lastCaseRepository;

    public List<LastCase> findAll(){
        return lastCaseRepository.findAll();
    }

    public LastCase findById(Long id){
        return lastCaseRepository.findById(id).get();
    }
}
