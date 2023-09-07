package com.example.interpol.controllers;

import com.example.interpol.services.CriminalsService;
import com.example.interpol.services.LastCaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/last_cases")
public class LastCaseController {

    private final LastCaseService lastCaseService;
    private final CriminalsService criminalsService;

    @GetMapping("/last_case/{id}")
    public String lastCaseInfo(@PathVariable Long id, Model model){
        model.addAttribute("case", lastCaseService.findById(id));
        model.addAttribute("criminals", criminalsService.getCriminalsByLastCaseId(id));
        return "last_case_info";
    }

}
