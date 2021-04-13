package com.licoreria.licoreria.headerInvoice.infrastructure;

import com.licoreria.licoreria.brands.aplication.create.BrandRequest;
import com.licoreria.licoreria.brands.domain.Brand;
import com.licoreria.licoreria.headerInvoice.aplication.create.HeaderInvoiceRequest;
import com.licoreria.licoreria.headerInvoice.domain.HeaderInvoice;
import com.licoreria.licoreria.headerInvoice.domain.create.HeaderInvoiceCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/headerInvoice")
public class HeaderInvoiceController {
    private final HeaderInvoiceCreator headerInvoiceCreator;
    //Create
    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody Request headerInvoice){
        HeaderInvoiceRequest headerInvoiceSave = new HeaderInvoiceRequest(headerInvoice.getNumeroFactura(), headerInvoice.getFecha(),headerInvoice.getNombreCliente());
        headerInvoiceCreator.create(headerInvoiceSave);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/headerInvoice/"+headerInvoiceSave.getNombreCliente());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }
    //Read
    @GetMapping("/{numeroFactura}")
    public ResponseEntity<HeaderInvoice> brandById(@PathVariable("numeroFactura") Long headerInvoiceNumeroFactura){
        Optional<HeaderInvoice> headerInvoiceById = headerInvoiceCreator.findHeaderInvoiceById(headerInvoiceNumeroFactura);
        if(headerInvoiceById.isEmpty()){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/headerInvoice/"+headerInvoiceNumeroFactura);
            return new ResponseEntity<>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<HeaderInvoice>(headerInvoiceById.get(),HttpStatus.OK);
    }
    //Update
    @PutMapping("/{numeroFactura}")
    public ResponseEntity<HttpStatus> update(@PathVariable("numeroFactura") Long headerInvoiceNumeroFactura, @RequestBody Request headerInvoice) throws Exception {
        HeaderInvoiceRequest headerInvoiceUpdate = new HeaderInvoiceRequest(headerInvoice.getNumeroFactura(), headerInvoice.getFecha(),headerInvoice.getNombreCliente());
        headerInvoiceCreator.update(headerInvoiceNumeroFactura,headerInvoiceUpdate);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/headerInvoice/"+headerInvoice.getNombreCliente());
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
    //Delete
    @DeleteMapping("/{numeroFactura}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("numeroFactura") Long headerInvoiceNumeroFactura) throws Exception {
        headerInvoiceCreator.deleteHeaderInvoiceById(headerInvoiceNumeroFactura);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/headerInvoice/"+headerInvoiceNumeroFactura);
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }

}
@Data
final class Request{
    private Long numeroFactura;
    private Date fecha;
    private String nombreCliente;
}