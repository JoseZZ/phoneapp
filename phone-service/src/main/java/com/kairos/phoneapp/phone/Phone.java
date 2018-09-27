package com.kairos.phoneapp.phone;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "phones")
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "imagen_url", nullable = false)
    private String imagenURL;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private Double precio;
}
