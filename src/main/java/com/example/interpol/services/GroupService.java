package com.example.interpol.services;

import com.example.interpol.entities.CriminalGroup;
import com.example.interpol.repositories.CriminalGroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GroupService {
    private final CriminalGroupRepository criminalGroupRepository;

    public List<CriminalGroup> getGroups(){
        return criminalGroupRepository.findAll();
    }
}
