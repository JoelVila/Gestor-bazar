package com.gestionBazar.Gestor.Bazar.services;

import com.gestionBazar.Gestor.Bazar.dto.VentaMayorDTO;
import com.gestionBazar.Gestor.Bazar.dto.VentaSimpleDTO;
import com.gestionBazar.Gestor.Bazar.model.Venta;
import com.gestionBazar.Gestor.Bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class VentaServices implements IVentaServices{

    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public String createVenta(Venta venta) {

        ventaRepo.save(venta);

        return "Venta creada";
    }

    @Override
    public List<Venta> findAllVenta() {

        List<Venta> listaVenta = ventaRepo.findAll();

        return listaVenta;
    }

    @Override
    public Venta findByIdVenta(Long id) {

        Venta venta = ventaRepo.findById(id).orElse(null);

        return venta;
    }

    @Override
    public String deleteVenta(Long id) {

        ventaRepo.deleteById(id);

        return "Venta eliminada";
    }

    @Override
    public Venta updateVenta(Long id, Venta venta) {
        Venta existingVenta = ventaRepo.findById(id).orElse(null);

        if (existingVenta != null) {
            existingVenta.setFecha_venta(venta.getFecha_venta());
            existingVenta.setListaProductos(venta.getListaProductos());
            existingVenta.setTotal(venta.getTotal());
            existingVenta.setUnCliente(venta.getUnCliente());

            return ventaRepo.save(existingVenta);
        }

        return null;
    }

    @Override
    public VentaMayorDTO getVentaConMasMonto() {

        List<Venta> ventas = ventaRepo.findAll();

        if (ventas.isEmpty()) return null;

        Venta mayorVenta = ventas.stream()
                .max(Comparator.comparing(Venta::getTotal))
                .orElse(null);

        if (mayorVenta == null) return null;

        VentaMayorDTO dto = new VentaMayorDTO();
        dto.setCodigoVenta(mayorVenta.getCodigo_venta());
        dto.setTotal(mayorVenta.getTotal());
        dto.setCantidadProductos(mayorVenta.getListaProductos().size());
        dto.setNombreCliente(mayorVenta.getUnCliente().getNombre());
        dto.setApellidoCliente(mayorVenta.getUnCliente().getApellido());

        return dto;
    }

    @Override
    public List<VentaSimpleDTO> getVentasSimples() {
        return List.of();
    }
}
