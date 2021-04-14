package com.licoreria.licoreria.warehouse.aplication.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
@Builder
public class WarehouseRequest
{
    private Long ciudadesUbicacion;

    private Long codigo;
    private Long capacidadMetrosCubicos;
}
