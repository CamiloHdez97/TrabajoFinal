package com.proyecto1.TrabajoFinal.dao;

import com.proyecto1.TrabajoFinal.models.Inventario;

import java.util.List;

public interface inventarioDao {

    List<Inventario> getProductos();
    void eliminar(Long id);

    void registrar(Inventario producto);
}
