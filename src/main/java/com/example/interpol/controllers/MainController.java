package com.example.interpol.controllers;

import com.example.interpol.entities.Language;
import com.example.interpol.repositories.StatusRepository;
import com.example.interpol.services.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class MainController {

    private final CriminalsService criminalsService;
    private final GroupService groupService;
    private final StatusService statusService;
    private final ProfessionService professionService;
    private final LanguageService languageService;

    @GetMapping("main")
    public String main() {
        return "main";
    }

    @GetMapping("criminals")
    public String criminals(Model model) {
        model.addAttribute("criminals", criminalsService.getCriminals());
        model.addAttribute("status", statusService.findAll());
        model.addAttribute("professions", professionService.findAll());
        model.addAttribute("languages", languageService.findAll());
        return "criminals";
    }

    @GetMapping("archive")
    public String archive(Model model) {
        model.addAttribute("criminals", criminalsService.getOutOfGameCriminals());
        return "archive";
    }

    @GetMapping("groups")
    public String groups(Model model){
        model.addAttribute("groups", groupService.getGroups());
        return "groups";
    }
}
