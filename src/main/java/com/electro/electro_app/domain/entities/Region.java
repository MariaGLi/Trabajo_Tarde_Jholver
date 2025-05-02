package com.electro.electro_app.domain.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"cities"})
@ToString(exclude = {"cities"})
@Entity
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50,nullable = false)
    private String name;

    @Embedded
    Audit audit = new Audit();

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    //JsonBackreference es para evitar la recursividad infinita al serializar el objeto
    //en formato JSON. Esto es útil cuando tienes relaciones bidireccionales entre entidades.
    //En este caso, la relación entre Country y Region es bidireccional, ya que un país puede tener varias regiones
    @JsonBackReference
    Country countries;

    @OneToMany(mappedBy = "regions")
    @JsonBackReference
    private Set<City> cities = new HashSet<>();

}
