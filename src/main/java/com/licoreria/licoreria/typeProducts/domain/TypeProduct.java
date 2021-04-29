package com.licoreria.licoreria.typeProducts.domain;

import com.licoreria.licoreria.typeProducts.domain.valueObject.TypeProductCodigo;
import com.licoreria.licoreria.typeProducts.domain.valueObject.TypeProductNombre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@Builder
public class TypeProduct {

  private TypeProductCodigo codigo;
  private TypeProductNombre nombre;
}
