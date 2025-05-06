package com.electro.electro_app.domain.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaRequestDTO {
    private Long cityId;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
}
