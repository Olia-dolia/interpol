package com.example.interpol.services;

import com.example.interpol.entities.CriminalGroup;
import com.example.interpol.entities.LastCase;
import com.example.interpol.repositories.LastCaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void deleteCase(Long id) {
        lastCaseRepository.deleteById(id);
    }

    public void addCase(LastCase lastCase) {
        lastCaseRepository.save(lastCase);
    }

    public void updateCase(Long id, LastCase lastCase) {
        Optional<LastCase> lCase = lastCaseRepository.findById(id);
        lCase.ifPresent(c -> {
            c.setCaseName(lastCase.getCaseName());
            c.setDescription(lastCase.getDescription());
            lastCaseRepository.save(c);
        });
    }
}
