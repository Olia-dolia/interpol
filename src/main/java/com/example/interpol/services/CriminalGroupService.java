package com.example.interpol.services;

import com.example.interpol.repositories.CriminalGroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CriminalGroupService {

    private final CriminalGroupRepository criminalGroupRepository;

    /*public Integer getNumberOfParticipantsByGroupName(){
        return criminalGroupRepository.findAll();
    }*/
}
