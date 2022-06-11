package com.proyecto1.TrabajoFinal.dao;

import com.proyecto1.TrabajoFinal.models.Inventario;
import com.proyecto1.TrabajoFinal.models.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

//Poder acceder al repositorio
@Repository

//Estructura de la consulta, fragmentos de transación.
@Transactional

public class InventarioDaoImp implements inventarioDao {

    //Conexión con la base de datos.
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Inventario> getProductos(){

        String query = "FROM Inventario";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void eliminar(Long id) {
        Inventario producto = entityManager.find(Inventario.class, id);
        entityManager.remove(producto);
    }

    @Override
    public void registrar(Inventario producto) {

        entityManager.merge(producto);

    }
}
