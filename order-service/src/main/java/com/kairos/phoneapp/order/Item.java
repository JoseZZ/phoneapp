package com.kairos.phoneapp.order;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "items")
public class Item implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "precio", nullable = false)
    private Long precio;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
