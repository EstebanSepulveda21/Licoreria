package com.licoreria.licoreria.headerInvoice.aplication.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
@AllArgsConstructor
@Getter
@Builder
public final class HeaderInvoiceRequest {
    private Long numeroFactura;
    private Date fecha;
    private String nombreCliente;
}
