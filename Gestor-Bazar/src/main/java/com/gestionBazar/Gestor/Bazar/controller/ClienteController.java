package com.gestionBazar.Gestor.Bazar.controller;


import com.gestionBazar.Gestor.Bazar.model.Cliente;
import com.gestionBazar.Gestor.Bazar.services.IClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteServices clienteServices;


    @PostMapping("/cliente/crear")
    public ResponseEntity<String> crearCliente(@RequestBody Cliente cliente) {
        clienteServices.createCliente(cliente);
        return ResponseEntity.ok("Cliente creado correctamente.");
    }

    @GetMapping("/clientes/traer")
    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteServices.findAllCliente();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/cliente/{id_cliente}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id_cliente) {
        Cliente cliente = clienteServices.findByIdCliente(id_cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("cliente/eliminar/{id_cliente}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Long id_cliente) {
        clienteServices.deleteCliente(id_cliente);
        return ResponseEntity.ok("Cliente eliminado correctamente.");
    }

    @PutMapping("/editar/{id_cliente}")
    public ResponseEntity<String> editarCliente(@PathVariable Long id_cliente, @RequestBody Cliente cliente) {
        Cliente updated = clienteServices.updateCliente(id_cliente, cliente);
        if (updated != null) {
            return ResponseEntity.ok("Cliente actualizado correctamente.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
