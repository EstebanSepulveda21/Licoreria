package com.licoreria.licoreria.typeProducts.aplication.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
@Builder
public final class TypeProductRequest {

    private Long codigo;
    private String tipo;
}
