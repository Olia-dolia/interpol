package com.example.interpol.controllers;

import com.example.interpol.entities.Criminal;
import com.example.interpol.services.CriminalsService;
import com.example.interpol.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@AllArgsConstructor
@Controller
public class CriminalsController {

    private final CriminalsService criminalsService;
    private final GroupService groupService;

    @GetMapping("criminal_info/{id}")
    public String getCriminal(@PathVariable Long id, Model model){
        Optional<Criminal> c = criminalsService.getCriminalById(id);
        if (c.isPresent()) {
            model.addAttribute("criminal", c.get());
            return "criminal_info";
        }
        return "redirect:/criminals";
    }

}
