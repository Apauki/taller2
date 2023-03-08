package com.itsqmet.Taller2.repositorio;

import com.itsqmet.Taller2.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaRepository extends JpaRepository<Persona, Integer>{
    
    
}
