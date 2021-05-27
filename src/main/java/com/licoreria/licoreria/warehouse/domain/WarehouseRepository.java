package com.licoreria.licoreria.warehouse.domain;

import com.licoreria.licoreria.warehouse.infrastructure.entities.WareHouseEntity;

import java.util.List;
import java.util.Optional;

public interface WarehouseRepository {
    void save(Warehouse warehouse);
    Optional<WareHouseEntity> findWarehouseById(Long codigo);
    void delete(WareHouseEntity wareHouseEntity);
    List<WareHouseEntity> getAll();
}