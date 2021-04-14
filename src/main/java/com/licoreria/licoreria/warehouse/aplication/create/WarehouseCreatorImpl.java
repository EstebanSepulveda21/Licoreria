package com.licoreria.licoreria.warehouse.aplication.create;

import com.licoreria.licoreria.shared.domain.Service;
import com.licoreria.licoreria.warehouse.domain.Warehouse;
import com.licoreria.licoreria.warehouse.domain.WarehouseRepository;
import com.licoreria.licoreria.warehouse.domain.create.WarehouseCreator;
import lombok.AllArgsConstructor;

import java.util.Optional;

@Service
@AllArgsConstructor
public class WarehouseCreatorImpl implements WarehouseCreator
{
    private final WarehouseRepository warehouseRepository;

    @Override
    public void create(WarehouseRequest warehouseRequest)
    {
        Warehouse warehouse = new Warehouse(
                warehouseRequest.getCiudadesUbicacion(),
                warehouseRequest.getCodigo(),
                warehouseRequest.getCapacidadMetrosCubicos());

        warehouseRepository.save(warehouse);
    }

    @Override
    public Optional<Warehouse> findWarehouseById(Long warehouseCodigo)
    {
        return warehouseRepository.findById(warehouseCodigo);
    }

    @Override
    public void update(Long codigo, WarehouseRequest warehouseRequest) throws Exception
    {
        Optional<Warehouse> warehouseUpdate = findWarehouseById(codigo);

        if(warehouseUpdate.isEmpty())
        {
            throw new Exception("No existe el codigo: " + codigo);
        }
        else
            {
                Warehouse warehouse = new Warehouse(
                        warehouseRequest.getCiudadesUbicacion(),
                        warehouseRequest.getCodigo(),
                        warehouseRequest.getCapacidadMetrosCubicos());

                warehouseRepository.save(warehouse);
            }
    }

    @Override
    public void deleteWarehouseById(Long warehouseCodigo) throws Exception
    {
        Optional<Warehouse> warehouseDelete = findWarehouseById(warehouseCodigo);

        if(warehouseDelete.isEmpty())
        {
            throw new Exception("No existe el codigo: " + warehouseDelete);
        }
        else
            {
                warehouseRepository.delete(warehouseDelete.get());
            }
    }
}
