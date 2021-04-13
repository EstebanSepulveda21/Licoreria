package com.licoreria.licoreria.products.infrastructure;

import com.licoreria.licoreria.brands.aplication.create.BrandRequest;
import com.licoreria.licoreria.brands.domain.Brand;
import com.licoreria.licoreria.products.aplication.create.ProductRequest;
import com.licoreria.licoreria.products.domain.Product;
import com.licoreria.licoreria.products.domain.create.ProductCreator;
import com.licoreria.licoreria.typeProducts.domain.TypeProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        ProductRequest productSave = new ProductRequest(request.getCodigo(), request.getNombre(),
                request.getTiposProductosCodigo(), request.getMarcasCodigo());

        productCreator.create(productSave);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/product/"+productSave.getNombre());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    //Read
    @GetMapping("/{codigo}")
    public ResponseEntity<Product> brandById(@PathVariable("codigo") Long productCodigo)
    {
        Optional<Product> productById = productCreator.findProductById(productCodigo);

        if(productById.isEmpty())
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/product/"+productCodigo);
            return new ResponseEntity<>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(productById.get(),HttpStatus.OK);
    }

    //Update
    @PutMapping("/{codigo}")
    public ResponseEntity<HttpStatus> update(@PathVariable("codigo") Long productCodigo, @RequestBody Request product) throws Exception
    {
        ProductRequest productUpdate = new ProductRequest(product.getCodigo(), product.getNombre(),
                product.getTiposProductosCodigo(), product.getMarcasCodigo());

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
    private Long codigo;
    private String nombre;

    private TypeProduct tiposProductosCodigo;
    private Brand marcasCodigo;
}
