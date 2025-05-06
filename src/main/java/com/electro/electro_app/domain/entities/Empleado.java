package com.electro.electro_app.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Embedded
    Audit audit = new Audit();

    @OneToOne
    @JoinColumn(name = "persona_id")
    @JsonBackReference
    Persona persona;

    @ManyToOne
    @JoinColumn(name = "arl_id")
    @JsonBackReference
    Arl arl;

    @ManyToOne
    @JoinColumn(name = "eps_id")
    @JsonBackReference
    Eps eps;
}
