package com.gestionBazar.Gestor.Bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaSimpleDTO {
    private Long codigoVenta;
    private String fechaVenta;
    private Double total;
}
