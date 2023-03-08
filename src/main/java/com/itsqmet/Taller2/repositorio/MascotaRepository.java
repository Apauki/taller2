package com.itsqmet.Taller2.repositorio;

import com.itsqmet.Taller2.entidades.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer>{
    
}
