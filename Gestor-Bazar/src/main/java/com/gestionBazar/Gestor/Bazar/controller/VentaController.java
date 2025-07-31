package com.gestionBazar.Gestor.Bazar.controller;

import com.gestionBazar.Gestor.Bazar.dto.VentaMayorDTO;
import com.gestionBazar.Gestor.Bazar.dto.VentaSimpleDTO;
import com.gestionBazar.Gestor.Bazar.model.Venta;
import com.gestionBazar.Gestor.Bazar.services.IVentaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaServices ventaService;

    @PostMapping("/venta/crear")
    public ResponseEntity<String> crearVenta(@RequestBody Venta venta) {
        ventaService.createVenta(venta);
        return ResponseEntity.ok("Venta creada correctamente.");
    }

    @GetMapping("/venta/traer")
    public ResponseEntity<List<Venta>> listarVentas() {
        return ResponseEntity.ok(ventaService.findAllVenta());
    }

    @GetMapping("/venta/{codigo_venta}")
    public ResponseEntity<Venta> obtenerVenta(@PathVariable Long codigo_venta) {
        Venta venta = ventaService.findByIdVenta(codigo_venta);
        return ResponseEntity.ok(venta);
    }

    @DeleteMapping("/venta/eliminar/{codigo_venta}")
    public ResponseEntity<String> eliminarVenta(@PathVariable Long codigo_venta) {
        ventaService.deleteVenta(codigo_venta);
        return ResponseEntity.ok("Venta eliminada correctamente.");
    }

    @PutMapping("venta/editar/{codigo_venta}")
    public ResponseEntity<String> editarVenta(@PathVariable Long codigo_venta, @RequestBody Venta venta) {
        Venta updated = ventaService.updateVenta(codigo_venta, venta);
        if (updated != null) {
            return ResponseEntity.ok("Venta actualizada correctamente.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/ventas/mayor_venta")
    public ResponseEntity<VentaMayorDTO> obtenerMayorVenta() {
        VentaMayorDTO mayorVenta = ventaService.getVentaConMasMonto();
        return ResponseEntity.ok(mayorVenta);
    }

    @GetMapping("ventaSimple/resumen")
    public ResponseEntity<List<VentaSimpleDTO>> getVentasSimples() {
        return ResponseEntity.ok(ventaService.getVentasSimples());
    }



}
