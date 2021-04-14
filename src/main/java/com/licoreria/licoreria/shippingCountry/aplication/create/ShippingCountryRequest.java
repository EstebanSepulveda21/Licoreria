package com.licoreria.licoreria.shippingCountry.aplication.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
@Builder
public class ShippingCountryRequest
{
    private Long codigo;
    private String nombre;
}
