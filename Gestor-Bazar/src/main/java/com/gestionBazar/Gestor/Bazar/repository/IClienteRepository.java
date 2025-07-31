package com.gestionBazar.Gestor.Bazar.repository;

import com.gestionBazar.Gestor.Bazar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository <Cliente, Long> {
}
