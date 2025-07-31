package com.gestionBazar.Gestor.Bazar.services;

import com.gestionBazar.Gestor.Bazar.dto.VentaMayorDTO;
import com.gestionBazar.Gestor.Bazar.dto.VentaSimpleDTO;
import com.gestionBazar.Gestor.Bazar.model.Venta;

import java.util.List;

public interface IVentaServices {
    String createVenta(Venta venta);
    List<Venta> findAllVenta();
    Venta findByIdVenta(Long id);
    String deleteVenta(Long id);
    Venta updateVenta(Long id, Venta venta);
    VentaMayorDTO getVentaConMasMonto();
    List<VentaSimpleDTO> getVentasSimples();

}
