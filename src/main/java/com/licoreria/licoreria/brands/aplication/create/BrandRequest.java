package com.licoreria.licoreria.brands.aplication.create;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
@Getter
@Builder
public class BrandRequest {

    private BigDecimal codigo;
    private String nombre;

}
