package com.kairos.phoneapp.phone;

import lombok.Data;

@Data
public class PhoneDTO {

    private final String imagenURL;
    private final String nombre;
    private final String descripcion;
    private final Double precio;

}
