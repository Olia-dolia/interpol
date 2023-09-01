package com.example.interpol.controllers;

import com.example.interpol.services.CriminalsService;
import com.example.interpol.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class MainController {

    private final CriminalsService criminalsService;
    private final GroupService groupService;

    @GetMapping("main")
    public String main() {
        return "main";
    }

    @GetMapping("criminals")
    public String criminals(Model model) {
        model.addAttribute("criminals", criminalsService.getCriminals());
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
