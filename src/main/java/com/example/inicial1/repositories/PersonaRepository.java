package com.example.inicial1.repositories;

import com.example.inicial1.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
    Optional<Persona> findById(long l);
    // Aquí puedes agregar métodos personalizados si es necesario
    //se comunica directamente con el bases de datos


    //nuevo
    //metodos de query
    List<Persona> findByNombreContainingOrApellidoContaining (String nombre, String apellido);

    //boolean existByDni(int dni);
    @Query(value= "SELECT p FROM Personas p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List<Persona> search(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro% ", nativeQuery = true)
    List<Persona> searchNativo(@Param("filtro")String filtro);
}