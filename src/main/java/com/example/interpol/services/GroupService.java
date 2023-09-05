package com.example.interpol.services;

import com.example.interpol.entities.CriminalGroup;
import com.example.interpol.repositories.CriminalGroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GroupService {
    private final CriminalGroupRepository criminalGroupRepository;

    public List<CriminalGroup> findAll() {
        return criminalGroupRepository.findAll();
    }

    public Optional<CriminalGroup> findById(Long id) {
        return criminalGroupRepository.findById(id);
    }

    public void deleteGroup(Long id) {
        criminalGroupRepository.deleteById(id);
    }

    public void add(CriminalGroup criminalGroup) {
        criminalGroupRepository.save(criminalGroup);
    }

    public void updateGroup(Long id, CriminalGroup criminalGroup) {
        Optional<CriminalGroup> group = criminalGroupRepository.findById(id);
        group.ifPresent(g -> {
            g.setName(criminalGroup.getName());
            g.setCriminalType(criminalGroup.getCriminalType());
            criminalGroupRepository.save(g);
        });
    }
}
