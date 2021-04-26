package com.licoreria.licoreria.warehouse.domain;

import com.licoreria.licoreria.warehouse.domain.valueObjects.WareHouseCapacidadMetrosCubicos;
import com.licoreria.licoreria.warehouse.domain.valueObjects.WareHouseCiudadesUbicacion;
import com.licoreria.licoreria.warehouse.domain.valueObjects.WareHouseCodigo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Warehouse")
@Table(name = "bodegas")
public class Warehouse
{
 /*   //@ManyToOne
    @Column(name = "ciudades_ubicacion")
    private Long ciudadesUbicacion;
    //------------------
    @Id
    @Column(name = "codigo")
    private Long codigo;
    //------------------
    @Column(name = "capacidad_metros_cubicos")
    private Long capacidadMetrosCubicos;*/

    private WareHouseCiudadesUbicacion ciudadesUbicacion;
    private WareHouseCodigo codigo;
    private WareHouseCapacidadMetrosCubicos capacidadMetrosCubicos;
}
