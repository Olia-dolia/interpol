package com.example.interpol.services;

import com.example.interpol.entities.Status;
import com.example.interpol.repositories.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public List<Status> findAll() {
        return statusRepository.findAll();
    }
}
