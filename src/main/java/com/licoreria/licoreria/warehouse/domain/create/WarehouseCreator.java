package com.licoreria.licoreria.warehouse.domain.create;

import com.licoreria.licoreria.products.aplication.create.ProductRequest;
import com.licoreria.licoreria.warehouse.aplication.create.WarehouseRequest;
import com.licoreria.licoreria.warehouse.domain.Warehouse;

import java.util.Optional;

public interface WarehouseCreator
{
    void create(WarehouseRequest warehouseRequest);
    Optional<Warehouse> findWarehouseById(Long warehouseCodigo);
    void update(Long codigo, WarehouseRequest warehouseRequest) throws Exception;
    void deleteWarehouseById(Long warehouseCodigo) throws Exception;
}
