package com.example.interpol.controllers;

import com.example.interpol.services.CriminalsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/criminals/filter")
public class FilterController {

    private final CriminalsService criminalsService;

    @GetMapping
    public String searchTxt(@RequestParam("filter_name") String name, Model model){
        if(!name.isEmpty() && name.length()>=3){
            model.addAttribute("criminals", criminalsService.getCriminalsByNameOrAlias(name.toLowerCase()));
        } else {
            model.addAttribute("criminals", criminalsService.getCriminals());
            return "redirect:/criminals";
        }
        return "criminals";
    }

    @GetMapping("/status")
    public String statusFilter(@RequestParam("status") String status, Model model){
        switch (status){
            case "a" -> model.addAttribute("criminals", criminalsService.getCriminalsByStatusId(1L));
            case "p" -> model.addAttribute("criminals", criminalsService.getCriminalsByStatusId(2L));
            case "o" -> model.addAttribute("criminals", criminalsService.getCriminalsByStatusId(3L));
            case "d" -> model.addAttribute("criminals", criminalsService.getCriminalsByStatusId(4L));
            case "all" -> {
                return "redirect:/criminals";
            }
        }
        return "criminals";
    }

    @GetMapping("/profession")
    public String professionFilter(@RequestParam("profession") int profession, Model model){
        model.addAttribute("criminals", criminalsService.getCriminalsByProfessionId((long) profession));
        return "criminals";
    }
}
