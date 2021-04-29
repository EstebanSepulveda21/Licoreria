package com.licoreria.licoreria.shippingCountry.domain;

import com.licoreria.licoreria.shippingCountry.domain.valueObject.ShippingCountryCodigo;
import com.licoreria.licoreria.shippingCountry.domain.valueObject.ShippingCountryNombre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class ShippingCountry
{
  private ShippingCountryCodigo codigo;
  private ShippingCountryNombre nombre;

}
