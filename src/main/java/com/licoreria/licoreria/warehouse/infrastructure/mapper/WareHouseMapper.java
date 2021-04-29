package com.licoreria.licoreria.warehouse.infrastructure.mapper;

import com.licoreria.licoreria.warehouse.aplication.create.WarehouseRequest;
import com.licoreria.licoreria.warehouse.domain.Warehouse;
import com.licoreria.licoreria.warehouse.domain.valueObjects.WareHouseCapacidadMetrosCubicos;
import com.licoreria.licoreria.warehouse.domain.valueObjects.WareHouseCiudadesUbicacion;
import com.licoreria.licoreria.warehouse.domain.valueObjects.WareHouseCodigo;
import com.licoreria.licoreria.warehouse.infrastructure.entities.WareHouseEntity;
import org.mapstruct.Mapper;

@Mapper
public abstract class WareHouseMapper {
    public Warehouse requestToWareHouse(WarehouseRequest warehouseRequest){
        return Warehouse.builder()
                .codigo(new WareHouseCodigo(warehouseRequest.getCodigo()))
                .capacidadMetrosCubicos(new WareHouseCapacidadMetrosCubicos(warehouseRequest.getCapacidadMetrosCubicos()))
                .ciudadesUbicacion(new WareHouseCiudadesUbicacion(warehouseRequest.getCiudadesUbicacion()))
                .build();
    }

    public WareHouseEntity wareHouseToWareHouseEntity(Warehouse warehouse){
        return WareHouseEntity.builder()
                .codigo(warehouse.getCodigo().value())
                .capacidadMetrosCubicos(warehouse.getCapacidadMetrosCubicos().value())
                .ciudadesUbicacion(warehouse.getCiudadesUbicacion().value())
                .build();
    }
}
