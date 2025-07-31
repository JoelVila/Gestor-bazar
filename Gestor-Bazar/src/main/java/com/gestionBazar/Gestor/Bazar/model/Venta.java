package com.gestionBazar.Gestor.Bazar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class Venta {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;
    @ManyToMany
    @JoinTable(
            name = "venta_producto",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> listaProductos;
    @ManyToOne
    @JoinColumn (name = "cliente_id")
    private Cliente unCliente;
}
