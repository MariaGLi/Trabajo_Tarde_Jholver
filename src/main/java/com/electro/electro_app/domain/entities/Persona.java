package com.electro.electro_app.domain.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
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

    @Embedded
    Audit audit = new Audit();

    private String nombre;

    private String apellido;

    private String email;

    private String telefono;

    private String direccion;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonBackReference
    City city;

    @ManyToOne
    @JoinColumn(name = "tipoDocumento_id")
    @JsonBackReference
    TipoDocumento tipoDocumento;

    @OneToOne(mappedBy = "persona",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Cliente clientes;

    @OneToOne(mappedBy = "persona",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Empleado empleados;

    @OneToOne(mappedBy = "persona",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Proveedor proveedores;
}
