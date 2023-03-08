package com.itsqmet.Taller2.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Min(10)
    private Integer cedula;
    
    private String nombrePersona;
    private int numContacto;
    private String correo;
    private String sector;
}
