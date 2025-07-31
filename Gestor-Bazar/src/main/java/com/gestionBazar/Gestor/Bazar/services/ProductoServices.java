package com.gestionBazar.Gestor.Bazar.services;

import com.gestionBazar.Gestor.Bazar.model.Producto;
import com.gestionBazar.Gestor.Bazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServices implements IProductoServices {

    @Autowired
    private IProductoRepository producRepo;

    @Override
    public String createProducto(Producto produc) {

        producRepo.save(produc);

        return "Producto creado";
    }

    @Override
    public List<Producto> findAllProducto() {
         List<Producto> listaProducto = producRepo.findAll();

         return listaProducto;
    }

    @Override
    public Producto findByIdProducto(Long id) {

        Producto pro = producRepo.findById(id).orElse(null);


        return pro;
    }

    @Override
    public String deleteProducto(Long id) {

        producRepo.deleteById(id);

        return "Producto eliminado";
    }

    @Override
    public Producto updateProducto(Long id, Producto producto) {
        Producto existingProducto = producRepo.findById(id).orElse(null);

        if (existingProducto != null) {
            existingProducto.setNombre(producto.getNombre());
            existingProducto.setMarca(producto.getMarca());
            existingProducto.setCosto(producto.getCosto());
            existingProducto.setCantidad_disponible(producto.getCantidad_disponible());

            return producRepo.save(existingProducto);
        }

        return null;
    }
}
