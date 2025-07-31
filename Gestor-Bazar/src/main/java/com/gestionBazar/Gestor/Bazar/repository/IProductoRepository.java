package com.gestionBazar.Gestor.Bazar.repository;

import com.gestionBazar.Gestor.Bazar.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository <Producto, Long> {
}
