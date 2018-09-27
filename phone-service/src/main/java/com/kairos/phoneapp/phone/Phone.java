package com.kairos.phoneapp.phone;

import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Phone {

    @NotNull
    @Id
    private Long id;

    @URL
    @NotEmpty
    private String imagenURL;

    @NotEmpty
    private String nombre;
    private String descripcion;

    @NotNull
    private Double precio;
}
