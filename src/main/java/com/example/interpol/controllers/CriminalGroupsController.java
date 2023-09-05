package com.example.interpol.controllers;

import com.example.interpol.entities.CriminalGroup;
import com.example.interpol.services.CriminalTypeService;
import com.example.interpol.services.CriminalsService;
import com.example.interpol.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/groups")
public class CriminalGroupsController {

    private final GroupService groupService;
    private final CriminalsService criminalsService;
    private final CriminalTypeService typeService;

    @GetMapping
    public String groups(Model model){
        model.addAttribute("groups", groupService.findAll());
        return "groups";
    }

    @GetMapping("/group_info/{id}")
    public String groupInfo(@PathVariable Long id, Model model){
        Optional<CriminalGroup> g = groupService.findById(id);
        if (g.isPresent()) {
            model.addAttribute("group", g.get());
            model.addAttribute("criminals", criminalsService.getParticipantsByCriminalGroupId(id));
            return "group_info";
        }
        return "redirect:/groups";
    }

    @GetMapping("/add_group")
    public String addGroupPage(Model model){
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("group", new CriminalGroup());
        return "add_group";
    }

    @PostMapping("/add_group")
    public String addGroup(@ModelAttribute("group") CriminalGroup criminalGroup){
        groupService.add(criminalGroup);
        return "redirect:/groups";
    }

    @GetMapping("/edit_group")
    public String editGroup(@RequestParam Long id, Model model){
        model.addAttribute("types", typeService.findAll());
        Optional<CriminalGroup> g = groupService.findById(id);
        if (g.isPresent()) {
            model.addAttribute("group", g.get());
            return "edit_group";
        }
        return "redirect:/groups";
    }

    @PostMapping("/edit_group")
    public String updateGroup(@RequestParam("group_id") Long id, @ModelAttribute("group") CriminalGroup criminalGroup){
        groupService.updateGroup(id,criminalGroup);
        return "redirect:/groups";
    }

    @GetMapping("/delete_group")
    public String deleteGroup(@RequestParam Long id){
        try {
            groupService.deleteGroup(id);
        } catch (Exception ignored) {
        }
        return "redirect:/groups";
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
