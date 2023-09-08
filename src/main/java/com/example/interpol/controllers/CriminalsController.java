package com.example.interpol.controllers;

import com.example.interpol.entities.*;
import com.example.interpol.services.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/criminals")
public class CriminalsController {

    private final CriminalsService criminalsService;
    private final GroupService groupService;
    private final StatusService statusService;
    private final ProfessionService professionService;
    private final LanguageService languageService;
    private final LastCaseService lastCaseService;

    @GetMapping
    public String criminals(Model model) {
        model.addAttribute("criminals", criminalsService.getCriminalsExceptArchive());
        model.addAttribute("status", statusService.findAll());
        model.addAttribute("professions", professionService.findAll());
        model.addAttribute("languages", languageService.findAll());
        return "criminals";
    }

    @GetMapping("/criminal_info/{id}")
    public String getCriminal(@PathVariable Long id, Model model) {
        Optional<Criminal> c = criminalsService.getCriminalById(id);
        if (c.isPresent()) {
            model.addAttribute("criminal", c.get());
            return "criminal_info";
        }
        return "redirect:/criminals";
    }

    @GetMapping("/add_criminal")
    public String addCriminalPage(Model model) {
        model.addAttribute("statuses", statusService.findAll());
        model.addAttribute("professions", professionService.findAll());
        model.addAttribute("languages", languageService.findAll());
        model.addAttribute("groups", groupService.findAll());
        model.addAttribute("lastCases", lastCaseService.findAll());
        model.addAttribute("language", new Language());
        model.addAttribute("criminal_group", new CriminalGroup());
        model.addAttribute("status", new Status());
        model.addAttribute("criminal", new Criminal());
        model.addAttribute("lastCase", new LastCase());
        return "add_criminal";
    }

    @PostMapping("/add_criminal")
    public String addCriminal(@RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName,
                              @RequestParam String alias, @RequestParam("date_birth") String dateBirth,
                              @RequestParam("place_birth") String placeBirth, @RequestParam String nationality,
                              @RequestParam(value = "languages") long[] languages, @RequestParam("eyes") String eyesColor,
                              @RequestParam("hair") String hairColor, @RequestParam(required = false) Double height, @RequestParam("last_place") String lastPlace,
                              @RequestParam Long criminalGroup, @RequestParam("special_signs") String specialSigns,
                              @RequestParam Long lastCase, @RequestParam Long profession,
                              @RequestParam Long status) {
        System.out.println(criminalGroup);
        criminalsService.addCriminal(firstName, lastName, alias, dateBirth, placeBirth, nationality, languages, eyesColor,
                hairColor, height, lastPlace, criminalGroup,
                specialSigns, lastCase, profession, status);
        return "redirect:/criminals";
    }

    /*@PostMapping("/add_criminal")
    public String add(@ModelAttribute("criminal") Criminal criminal){
        criminalsService.addCriminal(criminal);
        return "redirect:/criminals";
    }*/

    @GetMapping("/edit_criminal")
    public String editCriminalPage(@RequestParam Long id, Model model){
        model.addAttribute("statuses", statusService.findAll());
        model.addAttribute("professions", professionService.findAll());
        model.addAttribute("languages", languageService.findAll());
        model.addAttribute("groups", groupService.findAll());
        model.addAttribute("lastCases", lastCaseService.findAll());
        model.addAttribute("language", new Language());
        model.addAttribute("criminal_group", new CriminalGroup());
        model.addAttribute("status", new Status());
        model.addAttribute("lastCase", new LastCase());
        Optional<Criminal> c = criminalsService.getCriminalById(id);
        if (c.isPresent()) {
            model.addAttribute("criminal", c.get());
            return "edit_criminal";
        }
        return "redirect:/criminals";
    }

    @PostMapping("/edit_criminal")
    public String updateCriminal(@RequestParam("criminal_id") Long id, @RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName,
                                 @RequestParam String alias, @RequestParam("date_birth") String dateBirth,
                                 @RequestParam("place_birth") String placeBirth, @RequestParam String nationality,
                                 @RequestParam(value = "languages", required = false) long[] languages, @RequestParam("eyes") String eyesColor,
                                 @RequestParam("hair") String hairColor, @RequestParam(required = false) Double height, @RequestParam("last_place") String lastPlace,
                                 @RequestParam Long criminalGroup, @RequestParam("special_signs") String specialSigns,
                                 @RequestParam Long lastCase, @RequestParam Long profession,
                                 @RequestParam Long status) {
        criminalsService.updateCriminal(id,firstName, lastName, alias, dateBirth, placeBirth, nationality, languages, eyesColor,
                hairColor, height, lastPlace, criminalGroup,
                specialSigns, lastCase, profession, status);

        return "redirect:/criminals";
    }

    @GetMapping("/delete_criminal")
    public String deleteCriminal(@RequestParam Long id){
        try {
            criminalsService.deleteCriminal(id);
        } catch (Exception ignored) {
        }
        return "redirect:/criminals";
    }
}
