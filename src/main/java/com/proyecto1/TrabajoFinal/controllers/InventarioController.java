package com.proyecto1.TrabajoFinal.controllers;

import com.proyecto1.TrabajoFinal.dao.inventarioDao;
import com.proyecto1.TrabajoFinal.models.Inventario;
import com.proyecto1.TrabajoFinal.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventarioController {

    //Crea un Objeto de inventarioDaoImp, limitar su uso, se carga y comparte en memoria.
    @Autowired
    private inventarioDao inventarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

    @RequestMapping(value = "producto")
    public Inventario getproducto(@PathVariable Long id){
        Inventario producto = new Inventario();
        producto.setId(id);
        producto.setDescripcion("Camilo");
        producto.setValor(0);
        producto.setCant(1);
        return producto;
    }

    @RequestMapping(value = "api/productos", method = RequestMethod.GET)
    public List<Inventario> getProductos(@RequestHeader(value="Authorization") String token){
        if (!validarToken(token)) { return null; }
        return inventarioDao.getProductos();

    }

    @RequestMapping(value = "producto/123")
    public Inventario buscar(){
        Inventario producto = new Inventario();
        producto.setDescripcion("Camilo");
        producto.setValor(0);
        producto.setCant(0);
        return producto;
    }

    @RequestMapping(value = "producto/1324")
    public Inventario editar(){
        Inventario producto = new Inventario();
        producto.setDescripcion("Camilo");
        producto.setValor(0);
        producto.setCant(0);
        return producto;
    }

    @RequestMapping(value = "api/productos/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization") String token,
                         @PathVariable Long id) {
        if (!validarToken(token)) { return; }
        inventarioDao.eliminar(id);
    }

    @RequestMapping(value = "api/productos", method = RequestMethod.POST)
    public void registrarProducto(@RequestBody Inventario producto, @RequestHeader(value="Authorization") String token){
        if (!validarToken(token)) { return; }
        inventarioDao.registrar(producto);

    }

}

