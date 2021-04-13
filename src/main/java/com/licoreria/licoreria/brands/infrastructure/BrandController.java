package com.licoreria.licoreria.brands.infrastructure;
import com.licoreria.licoreria.brands.aplication.create.BrandRequest;
import com.licoreria.licoreria.brands.domain.Brand;
import com.licoreria.licoreria.brands.domain.create.BrandCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brand")
public class BrandController
{
    private final BrandCreator brandCreator;
    //Create
    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody Request brand){
        BrandRequest brandSave = new BrandRequest(brand.getCodigo(), brand.getNombre());
        brandCreator.create(brandSave);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/brand/"+brandSave.getNombre());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }
    //Read
    @GetMapping("/{codigo}")
    public ResponseEntity<Brand> brandById(@PathVariable("codigo") Long brandCodigo){
        Optional<Brand> brandById = brandCreator.findBrandById(brandCodigo);
        if(brandById.isEmpty()){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/brand/"+brandCodigo);
            return new ResponseEntity<>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Brand>(brandById.get(),HttpStatus.OK);
    }
    //Update
    @PutMapping("/{codigo}")
    public ResponseEntity<HttpStatus> update(@PathVariable("codigo") Long brandCodigo, @RequestBody Request brand) throws Exception {
        BrandRequest brandUpdate = new BrandRequest(brandCodigo, brand.getNombre());
        brandCreator.update(brandCodigo,brandUpdate);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/brand/"+brandUpdate.getNombre());
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
    //Delete
    @DeleteMapping("/{codigo}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("codigo") Long codigo) throws Exception {
        brandCreator.deleteBrandById(codigo);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/brand/"+codigo);
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
}
@Data
final class Request
{
    private Long codigo;
    private String nombre;
}