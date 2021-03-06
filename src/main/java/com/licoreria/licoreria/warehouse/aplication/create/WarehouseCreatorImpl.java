package com.licoreria.licoreria.warehouse.aplication.create;

import com.licoreria.licoreria.shared.domain.Service;
import com.licoreria.licoreria.warehouse.domain.Warehouse;
import com.licoreria.licoreria.warehouse.domain.WarehouseRepository;
import com.licoreria.licoreria.warehouse.domain.create.WarehouseCreator;
import com.licoreria.licoreria.warehouse.infrastructure.entities.WareHouseEntity;
import com.licoreria.licoreria.warehouse.infrastructure.mapper.WareHouseMapper;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WarehouseCreatorImpl implements WarehouseCreator
{
    private final WarehouseRepository warehouseRepository;
    private final WareHouseMapper wareHouseMapper;

    @Override
    public void create(WarehouseRequest warehouseRequest)
    {
        Warehouse warehouse = wareHouseMapper.requestToWareHouse(warehouseRequest);
        warehouseRepository.save(warehouse);
    }

    @Override
    public Optional<WareHouseEntity> findWarehouseById(Long warehouseCodigo)
    {
        return warehouseRepository.findWarehouseById(warehouseCodigo);
    }

    @Override
    public void update(Long codigo, WarehouseRequest warehouseRequest) throws Exception
    {
        Optional<WareHouseEntity> warehouseUpdate = findWarehouseById(codigo);
        if(warehouseUpdate.isEmpty()) {
            throw new Exception("No existe el codigo: " + codigo);
        }
        else {
            Warehouse warehouse = wareHouseMapper.requestToWareHouse(warehouseRequest);
            warehouseRepository.save(warehouse);
        }
    }

    @Override
    public void deleteWarehouseById(Long warehouseCodigo) throws Exception
    {
        Optional<WareHouseEntity> warehouseDelete = findWarehouseById(warehouseCodigo);
        if(warehouseDelete.isEmpty()) {
            throw new Exception("No existe el codigo: " + warehouseDelete);
        }
        else {
            warehouseRepository.delete(warehouseDelete.get());
        }
    }

    @Override
    public List<WareHouseEntity> getAll() {
        return warehouseRepository.getAll();
    }
}
