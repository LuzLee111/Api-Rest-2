package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.envers.Audited;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Table(name="libro")
@Audited
public class Libro extends Base{

    @Column(name="titulo")
    private String titulo;

    @Column(name = "fecha")
    private int fecha;

    @Column(name="genero")
    private String genero;

    @Column(name = "paginas")
    private int paginas;


    @ManyToMany(cascade = CascadeType.REFRESH) //cascade que asegura que persiste un libro siempre se actualiza los autores
    private List<Autor> autores;

    /*@ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;*/

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false) // Asegúrate de que este campo no sea nulo si es necesario
    private Persona persona;
}
