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

    @GetMapping("all_criminals")
    public String criminals(Model model) {
        model.addAttribute("criminals", criminalsService.getCriminals());
        return "all_criminals";
    }

    @GetMapping("all_groups")
    public String groups(Model model){
        model.addAttribute("groups", groupService.getGroups());
        return "all_groups";
    }
}
