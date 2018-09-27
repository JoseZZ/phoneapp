package com.kairos.phoneapp.phone;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class PhoneDTO implements Serializable{

    @NotNull
    private final String imagenURL;

    @NotEmpty
    private final String nombre;

    @NotEmpty
    private final String descripcion;

    @NotNull
    private final Double precio;

}
