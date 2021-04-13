package com.licoreria.licoreria.headerInvoice.aplication.create;

import com.licoreria.licoreria.headerInvoice.domain.HeaderInvoice;
import com.licoreria.licoreria.headerInvoice.domain.HeaderInvoiceRepository;
import com.licoreria.licoreria.headerInvoice.domain.create.HeaderInvoiceCreator;
import com.licoreria.licoreria.shared.domain.Service;
import lombok.AllArgsConstructor;

import java.util.Optional;

@Service
@AllArgsConstructor
public class HeaderInvoiceCreatorImpl implements HeaderInvoiceCreator {

    private final HeaderInvoiceRepository headerInvoiceRepository;

    @Override
    public void create(HeaderInvoiceRequest headerInvoiceRequest) {
        HeaderInvoice headerInvoice = new HeaderInvoice(headerInvoiceRequest.getNumeroFactura(),headerInvoiceRequest.getFecha(),
                headerInvoiceRequest.getNombreCliente());
        headerInvoiceRepository.save(headerInvoice);
    }

    @Override
    public Optional<HeaderInvoice> findHeaderInvoiceById(Long headerInvoiceCodigo) {
        return headerInvoiceRepository.findById(headerInvoiceCodigo);
    }

    @Override
    public void update(Long headerInvoiceCodigo, HeaderInvoiceRequest headerInvoiceRequest) throws Exception {
        Optional<HeaderInvoice> headerInvoiceUpdate = findHeaderInvoiceById(headerInvoiceCodigo);
        if(headerInvoiceUpdate.isEmpty()){
            throw new Exception("No existe el codigo: " + headerInvoiceCodigo);
        }else{
            HeaderInvoice headerInvoice = new HeaderInvoice(headerInvoiceRequest.getNumeroFactura(),headerInvoiceRequest.getFecha(),
                    headerInvoiceRequest.getNombreCliente());
            headerInvoiceRepository.save(headerInvoice);
        }
    }

    @Override
    public void deleteHeaderInvoiceById(Long headerInvoiceCodigo) throws Exception {
        Optional<HeaderInvoice> headerInvoiceDelete = findHeaderInvoiceById(headerInvoiceCodigo);
        if(headerInvoiceDelete.isEmpty()){
            throw new Exception("No existe el codigo: " + headerInvoiceCodigo);
        }else{
            headerInvoiceRepository.delete(headerInvoiceDelete.get());
        }
    }
}
