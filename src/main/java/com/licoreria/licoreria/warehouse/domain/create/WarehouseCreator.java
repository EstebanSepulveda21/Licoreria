package com.licoreria.licoreria.warehouse.domain.create;

import com.licoreria.licoreria.warehouse.aplication.create.WarehouseRequest;
import com.licoreria.licoreria.warehouse.infrastructure.entities.WareHouseEntity;

import java.util.List;
import java.util.Optional;

public interface WarehouseCreator
{
    void create(WarehouseRequest warehouseRequest);
    Optional<WareHouseEntity> findWarehouseById(Long warehouseCodigo);
    void update(Long codigo, WarehouseRequest warehouseRequest) throws Exception;
    void deleteWarehouseById(Long warehouseCodigo) throws Exception;
    List<WareHouseEntity> getAll();
}
