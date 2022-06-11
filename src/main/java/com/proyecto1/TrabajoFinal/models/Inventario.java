package com.proyecto1.TrabajoFinal.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


//Hace referencia a la base de datos
@Entity
//Indicar la tabla
@Table(name = "inventario")
//To string para toda la clase
@ToString @EqualsAndHashCode
public class Inventario {

    @Id // Marcar como llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")//Nombre del campo en la db.
    private Long id;

    @Getter @Setter @Column(name = "descripcion")
    private String descripcion;

    @Getter @Setter @Column(name = "valor")
    private double valor;

    @Getter @Setter @Column(name = "cant")
    private double cant;


}
