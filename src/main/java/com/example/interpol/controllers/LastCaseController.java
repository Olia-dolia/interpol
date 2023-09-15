package com.example.interpol.controllers;

import com.example.interpol.entities.CriminalGroup;
import com.example.interpol.entities.LastCase;
import com.example.interpol.services.CriminalsService;
import com.example.interpol.services.LastCaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/cases")
public class LastCaseController {

    private final LastCaseService lastCaseService;
    private final CriminalsService criminalsService;

    @GetMapping
    public String cases(Model model){
        model.addAttribute("cases", lastCaseService.findAll());
        model.addAttribute("case", new LastCase());
        return "cases";
    }

    @GetMapping("/last_case/{id}")
    public String lastCaseInfo(@PathVariable Long id, Model model){
        model.addAttribute("case", lastCaseService.findById(id));
        model.addAttribute("criminals", criminalsService.getCriminalsByLastCaseId(id));
        return "last_case_info";
    }

    @PostMapping("/add_case")
    public String addCase(@RequestParam String name, @RequestParam String description){
        lastCaseService.addCase(new LastCase(name, description));
        return "redirect:/last_cases";
    }

    @GetMapping("/edit_case")
    public String editCasePage(@RequestParam Long id, Model model) {
        model.addAttribute("case", lastCaseService.findById(id));
        return "edit_case";
    }

    @PostMapping("/edit_case")
    public String updateCase(@RequestParam Long id, @RequestParam String name, @RequestParam String description){
        lastCaseService.updateCase(id, new LastCase(name, description));
        return "redirect:/cases";
    }

    @GetMapping("/delete_case")
    public String deleteCase(@RequestParam Long id){
        try {
            lastCaseService.deleteCase(id);
        } catch (Exception ignored) {
        }
        return "redirect:/cases";
    }

}
