package com.gestionBazar.Gestor.Bazar.services;

import com.gestionBazar.Gestor.Bazar.model.Cliente;
import com.gestionBazar.Gestor.Bazar.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteServices implements IClienteServices {
    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public String createCliente(Cliente clien) {

        clienteRepo.save(clien);

        return "Cliente creado";
    }

    @Override
    public List<Cliente> findAllCliente() {

        List<Cliente> listaCliente =  clienteRepo.findAll();

        return listaCliente;
    }

    @Override
    public Cliente findByIdCliente(Long id) {

        Cliente clien = clienteRepo.findById(id).orElse(null);

        return clien;
    }

    @Override
    public String deleteCliente(Long id) {

        clienteRepo.deleteById(id);

        return "Cliente eliminado";
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {
        Cliente existingCliente = clienteRepo.findById(id).orElse(null);

        if (existingCliente != null) {
            existingCliente.setNombre(cliente.getNombre());
            existingCliente.setApellido(cliente.getApellido());
            existingCliente.setDni(cliente.getDni());

            return clienteRepo.save(existingCliente);
        }

        return null;
    }
}
