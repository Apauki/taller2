package com.itsqmet.Taller2.controller;

import com.itsqmet.Taller2.entidades.Mascota;
import com.itsqmet.Taller2.repositorio.MascotaRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MascotaController {
    
    @Autowired
    MascotaRepository mascotaRepository;
    
    //CRUD - CREATE
    @GetMapping("/listarMascota")
    public String listar(Model model){
        List<Mascota> mascotas= mascotaRepository.findAll();
        model.addAttribute("mascotas", mascotas);
        return "verMascotas";
    }
    
    @GetMapping("/formMascotas")
    public String formulario(Model model){
        model.addAttribute("mascota", new Mascota());
        
        return "formMascotas";
    }
    
    @PostMapping("/formMascotas")
    public String nuevaMascota(Mascota mascota){
        mascotaRepository.save(mascota);
        
        return "redirect:/listarMascota";
    }
    
    @GetMapping("/editarMascota/{id}")
    public String editarMascota(@PathVariable int id, Model model){
        Optional <Mascota> mascota = mascotaRepository.findById(id);
        model.addAttribute("mascota", mascota);
        return "formMascotas";
    }
    
    @GetMapping("/eliminarMascota/{id}")
    public String eliminarMascota(@PathVariable int id){
        mascotaRepository.deleteById(id);
        return "redirect:/listarMascota";
    }
}
