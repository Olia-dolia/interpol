package com.example.interpol.controllers;

import com.example.interpol.services.CriminalsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
@AllArgsConstructor
@RequestMapping("/criminals/filter")
public class FilterController {

    private final CriminalsService criminalsService;

    @GetMapping
    public String filter(@RequestParam("filter_name") String name, Model model){
        if(!name.isEmpty() && name.length()>=3){
            model.addAttribute("criminals", criminalsService.getCriminalsByNameOrAlias(name.toLowerCase()));
        } else {
            model.addAttribute("criminals", criminalsService.getCriminals());
            return "redirect:/criminals";
        }
        return "criminals";
    }
}
