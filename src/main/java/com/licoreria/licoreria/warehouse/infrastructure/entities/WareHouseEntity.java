package com.licoreria.licoreria.warehouse.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Warehouse")
@Table(name = "bodegas")
public class WareHouseEntity {
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
