package com.crudclients.crud.controller;

import com.crudclients.crud.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.crudclients.crud.service.PersonaService;

@Controller
@RequestMapping("/persons")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public String listPersons(Model model) {
        model.addAttribute("persons", personaService.listAll());
        return "person-list";
    }

    @GetMapping("/new")
    public String showFormNewPerson(Model model) {
        model.addAttribute("person", new Persona());
        return "person-form";
    }

    @PostMapping
    public String savePerson(@RequestBody Persona persona) {
        personaService.save(persona);
        return "redirect:/persons";
    }

    @PutMapping("/edit/{id}")
    public String showFormEditPerson(Model model, @PathVariable Long id) {
        model.addAttribute("person", personaService.obtainById(id));
        return "person-form";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personaService.delete(id);
        return "redirect:/persons";
    }
}
