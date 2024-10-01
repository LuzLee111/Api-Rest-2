package com.example.inicial1.controllers;

import com.example.inicial1.entities.Base;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.io.Serializable;

public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long> {
    @Autowired
            protected S servicio;

    @GetMapping("") //indica el uri específico de este método.
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());//statua de la respuesta, osea si sale bien o no, sale bien es ok.
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
            //retornar el response entity por si algo sale mal, vamos a tener un status que no encuentra
        }
    }



    @GetMapping("/{id}") //get mapping que recibe id
    public ResponseEntity<?> getOne(@PathVariable Long id){ //variable dentro de path
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
            //tambien puede ser .body(personaServices.findById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }





    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity){


        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity){

        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, entity));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id)); //no tiene contenido.
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
}
