package com.kairos.phoneapp.phone;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class PhoneDTO implements Serializable{

    @NotEmpty
    private Long id;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String descripcion;

    @NotNull
    private Double precio;

    @NotNull
    private String imagenURL;

}
