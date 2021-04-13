package com.licoreria.licoreria.headerInvoice.domain.create;

import com.licoreria.licoreria.headerInvoice.aplication.create.HeaderInvoiceRequest;
import com.licoreria.licoreria.headerInvoice.domain.HeaderInvoice;

import java.util.Optional;

public interface HeaderInvoiceCreator {
    void create(HeaderInvoiceRequest headerInvoiceRequest);
    Optional<HeaderInvoice> findHeaderInvoiceById(Long headerInvoiceCodigo);
    void update(Long headerInvoiceCodigo,HeaderInvoiceRequest headerInvoiceRequest)throws Exception;
    void deleteHeaderInvoiceById(Long headerInvoiceCodigo)throws Exception;
}
