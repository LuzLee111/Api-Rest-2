package com.example.inicial1.controllers;

import com.example.inicial1.entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
//Este BaseController se ´puede utilizar para todos los proyectos que necesitemos.
public interface BaseController <E extends Base, ID extends Serializable>{
    public ResponseEntity<?> getAll(); //? response entity recibe cualquier objeto que extiende de otros
    public ResponseEntity<?> getOne(@PathVariable ID id);
    public ResponseEntity<?> save(@RequestBody E entity);
    public ResponseEntity<?> update (@PathVariable ID id, @RequestBody E entity);
    public ResponseEntity<?> delete (@PathVariable ID id);
}
