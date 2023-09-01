package com.example.interpol.controllers;

import com.example.interpol.services.CriminalsService;
import com.example.interpol.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class CriminalsController {

    private final CriminalsService criminalsService;
    private final GroupService groupService;


}
