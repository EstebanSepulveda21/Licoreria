package com.licoreria.licoreria.warehouse.domain;

import com.licoreria.licoreria.warehouse.domain.valueObjects.WareHouseCapacidadMetrosCubicos;
import com.licoreria.licoreria.warehouse.domain.valueObjects.WareHouseCiudadesUbicacion;
import com.licoreria.licoreria.warehouse.domain.valueObjects.WareHouseCodigo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Warehouse {
    private WareHouseCiudadesUbicacion ciudadesUbicacion;
    private WareHouseCodigo codigo;
    private WareHouseCapacidadMetrosCubicos capacidadMetrosCubicos;
}
