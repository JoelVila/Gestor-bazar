package com.gestionBazar.Gestor.Bazar.services;

import com.gestionBazar.Gestor.Bazar.model.Cliente;

import java.util.List;

public interface IClienteServices {

    String createCliente(Cliente clien);
    List<Cliente> findAllCliente();
    Cliente findByIdCliente(Long id);
    String deleteCliente(Long id);
    Cliente updateCliente(Long id, Cliente cliente);

}
