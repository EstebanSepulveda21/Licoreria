package com.licoreria.licoreria.controllers.brand;

import com.licoreria.licoreria.brands.aplication.create.BrandRequest;
import com.licoreria.licoreria.brands.domain.create.BrandCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class BrandPutController
{

    private final BrandCreator brandCreator;

    @PutMapping("/api/v1/brands/{codigo}")
    public ResponseEntity<HttpStatus> create(@PathVariable BigDecimal codigo, @RequestBody Request brand)
    {
        BrandRequest brandRequest = new BrandRequest(codigo, brand.getNombre());

        brandCreator.create(brandRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

@Data
final class Request
{
    private BigDecimal codigo;
    private String nombre;
}