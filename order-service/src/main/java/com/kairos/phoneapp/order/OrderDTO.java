package com.kairos.phoneapp.order;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class OrderDTO implements Serializable{

    @NotNull
    private Long id;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellidos;

    @NotEmpty
    private String email;

    @NotEmpty
    private List<Long> telefonos;

    @NotEmpty
    private Double total;
}