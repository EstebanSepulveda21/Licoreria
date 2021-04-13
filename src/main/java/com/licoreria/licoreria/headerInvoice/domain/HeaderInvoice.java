package com.licoreria.licoreria.headerInvoice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "HeaderInvoice")
@Table(name = "cabecera_facturas")
public class HeaderInvoice {
    @Id
    @Column(name = "numero_factura")
    private Long numeroFactura;
    @Column(name = "fecha",
            nullable = false,
            columnDefinition = "timestamp"
    )
    private Date fecha;
    @Column(name = "nombre_cliente",
            nullable = false,
            columnDefinition = "varchar(80)"
    )
    private String nombreCliente;
}
