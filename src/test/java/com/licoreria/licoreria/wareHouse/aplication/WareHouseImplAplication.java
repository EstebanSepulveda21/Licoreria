package com.licoreria.licoreria.wareHouse.aplication;


import com.licoreria.licoreria.warehouse.aplication.create.WarehouseCreatorImpl;
import com.licoreria.licoreria.warehouse.aplication.create.WarehouseRequest;
import com.licoreria.licoreria.warehouse.domain.Warehouse;
import com.licoreria.licoreria.warehouse.domain.WarehouseRepository;
import com.licoreria.licoreria.warehouse.domain.create.WarehouseCreator;
import com.licoreria.licoreria.warehouse.domain.valueObjects.WareHouseCapacidadMetrosCubicos;
import com.licoreria.licoreria.warehouse.domain.valueObjects.WareHouseCiudadesUbicacion;
import com.licoreria.licoreria.warehouse.domain.valueObjects.WareHouseCodigo;
import com.licoreria.licoreria.warehouse.infrastructure.mapper.WareHouseMapper;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WareHouseImplAplication {

    @Test
    void created() throws Exception{

        WarehouseRepository warehouseRepository = mock(WarehouseRepository.class);

        WareHouseMapper wareHouseMapper = mock(WareHouseMapper.class);

        WarehouseCreator creator = new WarehouseCreatorImpl(warehouseRepository, wareHouseMapper);

        WarehouseRequest warehouseRequest = new WarehouseRequest(30L, 20L, 10L);


        when(wareHouseMapper.requestToWareHouse(warehouseRequest))
                .thenReturn(new Warehouse( new WareHouseCiudadesUbicacion( 30L),
                        new WareHouseCodigo(20L),new WareHouseCapacidadMetrosCubicos(10L)));
        creator.create(warehouseRequest);
    }

}
