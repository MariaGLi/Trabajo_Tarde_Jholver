package com.electro.electro_app.domain.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "personas")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  
    private String name;

    private String lastName;

    private String email;

    @Column(length = 20, nullable = false)
    private String phone;

    private String address;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonBackReference("persona-city")
    City city;

    @ManyToOne
    @JoinColumn(name = "tipoDocumento_id")
    @JsonBackReference("tipoDocumento-persona")
    TipoDocumento tipoDocumento;

    @OneToOne(mappedBy = "persona",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Cliente clientes;

    // @OneToOne(mappedBy = "persona",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    // @JsonManagedReference
    // private Empleado empleados;

    // @OneToOne(mappedBy = "persona",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    // @JsonManagedReference
    // private Proveedor proveedores;
    @Embedded
    Audit audit = new Audit();

}