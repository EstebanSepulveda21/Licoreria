package com.licoreria.licoreria.products.infrastructure;

import com.licoreria.licoreria.products.aplication.create.ProductRequest;
import com.licoreria.licoreria.products.domain.Product;
import com.licoreria.licoreria.products.domain.create.ProductCreator;
import com.licoreria.licoreria.products.infrastructure.entities.ProductEntity;
import com.licoreria.licoreria.warehouse.infrastructure.entities.WareHouseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController
{
    private final ProductCreator productCreator;

    //Create
    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody Request request)
    {
        ProductRequest productSave = new ProductRequest(
                request.getTiposProductosCodigo(),
                request.getMarcasCodigo(),
                request.getPaisEnviosCodigo(),
                request.getBodegasCodigo(),
                request.getCodigo(),
                request.getNombre());

        productCreator.create(productSave);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/product/"+productSave.getNombre());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    //Read
    @GetMapping("/{codigo}")
    public ResponseEntity<ProductEntity> brandById(@PathVariable("codigo") Long productCodigo){
        Optional<ProductEntity> productById = productCreator.findProductById(productCodigo);
        if(productById.isEmpty()) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/product/"+productCodigo);
            return new ResponseEntity<>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productById.get(),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAll(){
        return ResponseEntity.ok().body(this.productCreator.getAll());
    }

    //Update
    @PutMapping("/{codigo}")
    public ResponseEntity<HttpStatus> update(@PathVariable("codigo") Long productCodigo, @RequestBody Request product) throws Exception
    {
        ProductRequest productUpdate = new ProductRequest(
                product.getTiposProductosCodigo(),
                product.getMarcasCodigo(),
                product.getPaisEnviosCodigo(),
                product.getBodegasCodigo(),
                product.getCodigo(),
                product.getNombre());

        productCreator.update(productCodigo,productUpdate);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/product/"+productUpdate.getNombre());
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/{codigo}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("codigo") Long productCodigo) throws Exception
    {
        productCreator.deleteProductById(productCodigo);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/product/"+productCodigo);
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
}

@Data
final class Request
{
    private Long tiposProductosCodigo;
    private Long marcasCodigo;
    private Long paisEnviosCodigo;
    private Long bodegasCodigo;
    private Long codigo;
    private String nombre;
}
