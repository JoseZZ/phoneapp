package com.kairos.phoneapp.order;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class ItemDTO implements Serializable {

    @NotNull
    private Long id;

    @NotEmpty
    private String nombre;

    @NotNull
    private Long precio;

    @NotNull
    private Long order;
}
