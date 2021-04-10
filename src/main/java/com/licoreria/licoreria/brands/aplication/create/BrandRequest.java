package com.licoreria.licoreria.brands.aplication.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Getter
@Builder
public final class BrandRequest {

    private BigDecimal codigo;
    private String nombre;

}
