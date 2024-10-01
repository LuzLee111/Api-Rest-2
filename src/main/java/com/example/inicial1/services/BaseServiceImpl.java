package com.example.inicial1.services;

import com.example.inicial1.entities.Base;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.BaseRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {

    protected BaseRepository<E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository){
        this.baseRepository=baseRepository;
    }

    @Override
    @Transactional
    public List<E> findAll() throws Exception {
        try{
            List<E> entities= baseRepository.findAll(); //optener en bases de datos todas las personas que tenemos
            return entities;
        }catch(Exception e){
            throw new Exception(e.getMessage()); //enviar el mensaje de excepcion, es capturado en controlador.
        }
    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try{
            Optional<E> entityOptional=baseRepository.findById((Id) id); //no sabemos si en bases de datos encontramos uuna entidad que tenga ese id como clave primaria.
            return entityOptional.get();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try{
            entity =baseRepository.save(entity); //usa repositorio en save.
            return entity;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try{
            Optional<E> entityOptional= baseRepository.findById((Id) id);
            E entityUpdate= entityOptional.get();
            entityUpdate= baseRepository.save(entity);
            return entityUpdate;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try{
            if(baseRepository.existsById((Id) id)){ //usamos el if para ver si existe una persona con id que indicamos.
                baseRepository.deleteById((Id) id);
                return true;
            }else{
                throw new Exception();
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
