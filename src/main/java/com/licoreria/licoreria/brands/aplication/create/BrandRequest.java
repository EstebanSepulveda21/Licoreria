package com.licoreria.licoreria.brands.aplication.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;


@Data
@AllArgsConstructor
@Getter
@Builder
public final class BrandRequest {
    private Long codigo;
    private String nombre;
}
