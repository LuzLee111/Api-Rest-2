package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.BaseRepository;
import com.example.inicial1.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService{
    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository){
        super(baseRepository);
    }


    //nuevo
    @Override
    public List<Persona> search(String filtro) throws Exception {
        try{
            List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro); //un filtro para nombre y una para apellido
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
