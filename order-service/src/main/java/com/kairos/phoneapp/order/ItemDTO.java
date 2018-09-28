package com.kairos.phoneapp.order;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ItemDTO implements Serializable {

    @NotNull
    private Long id;

    @NotEmpty
    private String nombre;

    @NotNull
    private Long precio;

    @NotNull
    private Order order;
}
