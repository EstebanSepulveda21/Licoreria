package com.licoreria.licoreria.warehouse.infrastructure;

import com.licoreria.licoreria.warehouse.domain.Warehouse;
import com.licoreria.licoreria.warehouse.domain.WarehouseRepository;
import com.licoreria.licoreria.warehouse.infrastructure.entities.WareHouseEntity;
import com.licoreria.licoreria.warehouse.infrastructure.mapper.WareHouseMapper;
import lombok.AllArgsConstructor;
import java.util.Optional;

@AllArgsConstructor
public class WareHuseRepositoryPostgres implements WarehouseRepository {

    private final WareHouseRepositoryJPA wareHouseRepositoryJPA;
    private final WareHouseMapper wareHouseMapper;

    @Override
    public void save(Warehouse warehouse) {
        wareHouseRepositoryJPA.save(wareHouseMapper.wareHouseToWareHouseEntity(warehouse));
    }

    @Override
    public Optional<WareHouseEntity> findWarehouseById(Long codigo) {
        return wareHouseRepositoryJPA.findById(codigo);
    }

    @Override
    public void delete(WareHouseEntity wareHouseEntity) {
        wareHouseRepositoryJPA.deleteById(wareHouseEntity.getCodigo());
    }
}
