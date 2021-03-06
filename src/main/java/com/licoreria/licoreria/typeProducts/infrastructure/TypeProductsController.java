package com.licoreria.licoreria.typeProducts.infrastructure;
import com.licoreria.licoreria.locationCities.infrastructure.entities.LocationCitiesEntity;
import com.licoreria.licoreria.typeProducts.aplication.create.TypeProductRequest;
import com.licoreria.licoreria.typeProducts.domain.TypeProduct;
import com.licoreria.licoreria.typeProducts.infrastructure.entities.TypeProductsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.licoreria.licoreria.typeProducts.domain.create.TypeProductCreator;

import java.util.List;
import java.util.Optional;
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/typeProducts")
public class TypeProductsController {

    private final TypeProductCreator typeProductCreator;
    //Create
    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody Request typeProduct){
        TypeProductRequest typeProductSave = new TypeProductRequest(typeProduct.getCodigo(), typeProduct.getTipo());
        typeProductCreator.create(typeProductSave);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/typeProduct/"+typeProductSave.getTipo());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }
    //Read
    @GetMapping("/{codigo}")
    public ResponseEntity<TypeProductsEntity> typeProductById(@PathVariable("codigo") Long typeProductCodigo){
        Optional<TypeProductsEntity> typeProductById = typeProductCreator.findTypeProductById(typeProductCodigo);
        if(typeProductById.isEmpty()){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/typeProduct/"+typeProductCodigo);
            return new ResponseEntity<>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TypeProductsEntity>(typeProductById.get(),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TypeProductsEntity>> getAll(){
        return ResponseEntity.ok().body(this.typeProductCreator.getAll());
    }
    //Update
    @PutMapping("/{codigo}")
    public ResponseEntity<HttpStatus> update(@PathVariable("codigo") Long typeProductCodigo, @RequestBody Request typeProduct) throws Exception {
        TypeProductRequest typeProductUpdate = new TypeProductRequest(typeProductCodigo, typeProduct.getTipo());
        typeProductCreator.update(typeProductCodigo,typeProductUpdate);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/typeProduct/"+typeProductUpdate.getTipo());
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
    //Delete
    @DeleteMapping("/{codigo}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("codigo") Long codigo) throws Exception {
        typeProductCreator.deleteTypeProductById(codigo);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/typeProduct/"+codigo);
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
}
@Data
final class Request
{
    private Long codigo;
    private String tipo;
}