package com.itsqmet.Taller2.controller;


import com.itsqmet.Taller2.entidades.Persona;
import com.itsqmet.Taller2.repositorio.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonaController {
    @Autowired
    PersonaRepository personaRepository;
    
    //CRUD - CREATE
    @GetMapping("/listarPersona")
    public String listar(Model model){
        List<Persona> personas= personaRepository.findAll();
        model.addAttribute("personas", personas);
        return "verPersonas";
    }
    
    @GetMapping("/formPersonas")
    public String formulario(Model model){
        model.addAttribute("persona", new Persona());
        
        return "formPersonas";
    }
    
    @PostMapping("/formPersonas")
    public String nuevaPersona(Persona persona){
        personaRepository.save(persona);
        
        return "redirect:/listarPersona";
    }
    
    @GetMapping("/editarPersona/{id}")
    public String editarPersona(@PathVariable int id, Model model){
        Optional <Persona> persona = personaRepository.findById(id);
        model.addAttribute("persona", persona);
        return "formPersonas";
    }
    
    @GetMapping("/eliminarPersona/{id}")
    public String eliminarPersona(@PathVariable int id){
        personaRepository.deleteById(id);
        return "redirect:/listarPersona";
    }
}
