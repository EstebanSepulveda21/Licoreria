package com.licoreria.licoreria.warehouse.infrastructure;

import com.licoreria.licoreria.warehouse.aplication.create.WarehouseRequest;
import com.licoreria.licoreria.warehouse.domain.Warehouse;
import com.licoreria.licoreria.warehouse.domain.create.WarehouseCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("api/v1/warehouse")
public class WarehouseController
{
    private final WarehouseCreator warehouseCreator;

    //Create
    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody Request request)
    {
        WarehouseRequest warehouseSave = new WarehouseRequest(
                request.getCiudadesUbicacion(),
                request.getCodigo(),
                request.getCapacidadMetrosCubicos());

        warehouseCreator.create(warehouseSave);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/warehouse/"+warehouseSave.getCodigo());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    //Read
    @GetMapping("/{codigo}")
    public ResponseEntity<Warehouse> warehouseById(@PathVariable("codigo") Long warehouseCodigo)
    {
        Optional<Warehouse> warehouseById = warehouseCreator.findWarehouseById(warehouseCodigo);

        if(warehouseById.isEmpty())
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/warehouse/"+warehouseCodigo);
            return new ResponseEntity<>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Warehouse>(warehouseById.get(),HttpStatus.OK);
    }

    //Update
    @PutMapping("/{codigo}")
    public ResponseEntity<HttpStatus> update(@PathVariable("codigo") Long warehouseCodigo, @RequestBody Request warehouse) throws Exception
    {
        WarehouseRequest warehouseUpdate = new WarehouseRequest(
                warehouse.getCiudadesUbicacion(),
                warehouse.getCodigo(),
                warehouse.getCapacidadMetrosCubicos());

        warehouseCreator.update(warehouseCodigo,warehouseUpdate);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/warehouse/"+warehouseCodigo.getClass());
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/{codigo}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("codigo") Long warehouseCodigo) throws Exception
    {
        warehouseCreator.deleteWarehouseById(warehouseCodigo);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/warehouse/"+warehouseCodigo);
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
}

@Data
final class Request
{
    private Long ciudadesUbicacion;
    private Long codigo;
    private Long capacidadMetrosCubicos;
}
