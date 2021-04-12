package com.licoreria.licoreria.controllers.brand;
import com.licoreria.licoreria.brands.aplication.create.BrandRequest;
import com.licoreria.licoreria.brands.domain.Brand;
import com.licoreria.licoreria.brands.domain.create.BrandCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brand")
public class BrandController
{
    private final BrandCreator brandCreator;

    @PutMapping("/save")
    public ResponseEntity<HttpStatus> create(@RequestBody Request brand)
    {
        BrandRequest brandRequest = new BrandRequest(brand.getCodigo(), brand.getNombre());
        brandCreator.create(brandRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
@Data
final class Request
{
    private Long codigo;
    private String nombre;
}