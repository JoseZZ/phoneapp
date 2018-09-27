package com.kairos.phoneapp.phone;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
public class Phone implements Serializable {

    @NotNull
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String imagenURL;

    @NotEmpty
    private String nombre;

    private String descripcion;

    @NotNull
    private Double precio;
}
