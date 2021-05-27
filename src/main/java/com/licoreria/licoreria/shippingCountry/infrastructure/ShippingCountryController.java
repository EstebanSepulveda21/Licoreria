package com.licoreria.licoreria.shippingCountry.infrastructure;



import com.licoreria.licoreria.brands.aplication.create.BrandRequest;
import com.licoreria.licoreria.locationCities.infrastructure.entities.LocationCitiesEntity;
import com.licoreria.licoreria.shippingCountry.aplication.create.ShippingCountryRequest;

import com.licoreria.licoreria.shippingCountry.domain.ShippingCountry;
import com.licoreria.licoreria.shippingCountry.domain.create.ShippingCountryCreator;
import com.licoreria.licoreria.shippingCountry.infrastructure.entities.ShippingCountryEntity;
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
@RequestMapping("api/v1/shippingCountry")
public class ShippingCountryController
{
    private final ShippingCountryCreator shippingCountryCreator;

    //Create
    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody Request shippingCountry)
    {
        ShippingCountryRequest shippingCountrySave = new ShippingCountryRequest(shippingCountry.getCodigo(),
                shippingCountry.getNombre());
        shippingCountryCreator.create(shippingCountrySave);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/shippingCountry/"+shippingCountrySave.getNombre());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    //Read
    @GetMapping("/{codigo}")
    public ResponseEntity<ShippingCountryEntity> shippingCountryById(@PathVariable("codigo") Long shippingCountryCodigo)
    {
        Optional<ShippingCountryEntity> shippingCountrById = shippingCountryCreator.findShippingCountryById(shippingCountryCodigo);
        if(shippingCountrById.isEmpty())
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/shippingCountry/"+shippingCountryCodigo);
            return new ResponseEntity<>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ShippingCountryEntity>(shippingCountrById.get(),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ShippingCountryEntity>> getAll(){
        return ResponseEntity.ok().body(this.shippingCountryCreator.getAll());
    }
    //Update
    @PutMapping("/{codigo}")
    public ResponseEntity<HttpStatus> update(@PathVariable("codigo") Long shippingCountryCodigo, @RequestBody Request shippingCountry) throws Exception
    {
        ShippingCountryRequest shippingCountryUpdate = new ShippingCountryRequest(shippingCountryCodigo, shippingCountry.getNombre());
        shippingCountryCreator.update(shippingCountryCodigo,shippingCountryUpdate);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/shippingCountry/"+shippingCountryUpdate.getNombre());
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/{codigo}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("codigo") Long codigo) throws Exception {
        shippingCountryCreator.deleteShippingCountryById(codigo);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/shippingCountry/"+codigo);
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
}

@Data
final class Request
{
    private Long codigo;
    private String nombre;
}
