package com.example.interpol.services;

import com.example.interpol.entities.Criminal;
import com.example.interpol.repositories.CriminalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CriminalsService {
    private final CriminalRepository criminalRepository;

    public List<Criminal> getCriminals(){
        return criminalRepository.findAll();
    }

    public List<Criminal> getOutOfGameCriminals(){
        return criminalRepository.findCriminalsByStatusStatus("Out of game");
    }

    public Integer getParticipantsByCriminalGroupId(Long id){
        return criminalRepository.findCriminalByCriminalGroupId(id).size();
    }

    public Optional<Criminal> getCriminalById(Long id) {
        return criminalRepository.findById(id);
    }
}
