package com.gestionBazar.Gestor.Bazar.services;

import com.gestionBazar.Gestor.Bazar.model.Producto;

import java.util.List;

public interface IProductoServices {

    String createProducto(Producto produc);
    List<Producto> findAllProducto();
    Producto findByIdProducto(Long id);
    String deleteProducto(Long id);
    Producto updateProducto(Long id, Producto producto);



}
