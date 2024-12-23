package com.crudclients.crud.service;

import com.crudclients.crud.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crudclients.crud.repository.PersonalRepository;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonalRepository personalRepository;

    public List<Persona> listAll() {
        return personalRepository.findAll();
    }

    public Persona save(Persona persona) {
        return personalRepository.save(persona);
    }

    public Persona obtainById(Long id) {
        return personalRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        personalRepository.deleteById(id);
    }
}
