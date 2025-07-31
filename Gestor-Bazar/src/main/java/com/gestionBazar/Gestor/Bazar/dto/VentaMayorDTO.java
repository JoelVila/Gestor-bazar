package com.gestionBazar.Gestor.Bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaMayorDTO {

    private Long codigoVenta;
    private Double total;
    private Integer cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;
}
