package com.gestionBazar.Gestor.Bazar.controller;

import com.gestionBazar.Gestor.Bazar.model.Cliente;
import com.gestionBazar.Gestor.Bazar.model.Producto;
import com.gestionBazar.Gestor.Bazar.repository.IProductoRepository;
import com.gestionBazar.Gestor.Bazar.services.IProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController{

    @Autowired
    private IProductoServices productoService;

    @PostMapping("/producto/crear")
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        productoService.createProducto(producto);
        return ResponseEntity.ok("Producto creado correctamente.");
    }

    @GetMapping("/productos/traer")
    public ResponseEntity<List<Producto>> listarProductos() {
        return ResponseEntity.ok(productoService.findAllProducto());
    }

    @GetMapping("/producto/{codigo_producto}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Long codigo_producto) {
        Producto producto = productoService.findByIdProducto(codigo_producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/producto/eliminar/{codigo_producto}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long codigo_producto) {
        productoService.deleteProducto(codigo_producto);
        return ResponseEntity.ok("Producto eliminado correctamente.");
    }

    @PutMapping("/producto/editar/{codigo_producto}")
    public ResponseEntity<String> editarProducto(@PathVariable Long codigo_producto, @RequestBody Producto producto) {
        Producto updated = productoService.updateProducto(codigo_producto, producto);
        if (updated != null) {
            return ResponseEntity.ok("Producto actualizado correctamente.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
