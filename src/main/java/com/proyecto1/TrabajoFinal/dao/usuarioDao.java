package com.proyecto1.TrabajoFinal.dao;

import com.proyecto1.TrabajoFinal.models.Usuario;

import java.util.List;

public interface usuarioDao {

    List<Usuario> getUsuarios();
    void eliminar(Long id);

    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
