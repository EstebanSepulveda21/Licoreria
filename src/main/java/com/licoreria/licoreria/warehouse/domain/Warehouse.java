package com.licoreria.licoreria.warehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Warehouse")
@Table(name = "bodegas")
public class Warehouse
{
    //@ManyToOne
    @Column(name = "ciudades_ubicacion")
    private Long ciudadesUbicacion;
    //------------------
    @Id
    @Column(name = "codigo")
    private Long codigo;
    //------------------
    @Column(name = "capacidad_metros_cubicos")
    private Long capacidadMetrosCubicos;
}
