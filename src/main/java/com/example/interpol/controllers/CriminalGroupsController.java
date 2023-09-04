package com.example.interpol.controllers;

import com.example.interpol.services.CriminalGroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class CriminalGroupsController {

    private final CriminalGroupService criminalGroupService;
}
