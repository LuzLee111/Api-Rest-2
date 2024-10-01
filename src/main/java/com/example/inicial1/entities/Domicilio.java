package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Table(name="domiclio")
@Audited
public class Domicilio extends Base{

    @Column(name="calle")
    private String calle;

    @Column(name = "numero")
    private int numero;


    @ManyToOne(optional = true)//no puede ser opcional, no puede ser nula
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;


}
