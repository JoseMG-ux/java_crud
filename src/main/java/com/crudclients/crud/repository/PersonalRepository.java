package com.crudclients.crud.repository;

import com.crudclients.crud.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRepository extends JpaRepository <Persona, Long> {
}
