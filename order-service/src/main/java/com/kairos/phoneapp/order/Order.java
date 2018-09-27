package com.kairos.phoneapp.order;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Order implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefonos", nullable = false)
    private List<Long> telefonos;

    @Column(name = "total", nullable = false)
    private Double total;
}
