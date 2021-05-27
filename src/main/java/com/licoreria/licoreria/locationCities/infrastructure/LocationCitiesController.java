package com.licoreria.licoreria.locationCities.infrastructure;


import com.licoreria.licoreria.brands.infrastructure.entities.BrandEntity;
import com.licoreria.licoreria.locationCities.infrastructure.entities.LocationCitiesEntity;
import com.licoreria.licoreria.locationCities.aplication.create.LocationCitiesRequest;
import com.licoreria.licoreria.locationCities.domain.LocationCities;
import com.licoreria.licoreria.locationCities.domain.create.LocationCitiesCreator;
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
@RequestMapping("api/v1/locationCities")
public class LocationCitiesController
{
    private final LocationCitiesCreator locationCitiesCreator;

    //Create
    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody Request locationCities)
    {
        LocationCitiesRequest locationCitiesSave = new LocationCitiesRequest(locationCities.getCodigo(),
                locationCities.getNombre());

        locationCitiesCreator.create(locationCitiesSave);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/locationCities/"+locationCitiesSave.getNombre());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    //Read
    @GetMapping("/{codigo}")
    public ResponseEntity<LocationCitiesEntity> locationCitiesById(@PathVariable("codigo") Long locationCitiesCodigo)
    {
        Optional<LocationCitiesEntity> locationCitiesById =
                locationCitiesCreator.findLocationCitiesById(locationCitiesCodigo);
        if(locationCitiesById.isEmpty())
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/locationCities/"+locationCitiesCodigo);
            return new ResponseEntity<>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LocationCitiesEntity>(locationCitiesById.get(),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BrandEntity>> getAll(){
        return ResponseEntity.ok().body(this.locationCitiesCreator.getAll());
    }

    //Update
    @PutMapping("/{codigo}")
    public ResponseEntity<HttpStatus> update(@PathVariable("codigo") Long locationCitiesCodigo, @RequestBody Request locationCities) throws Exception
    {
        LocationCitiesRequest locationCitiesUpdate = new LocationCitiesRequest(locationCitiesCodigo, locationCities.getNombre());
        locationCitiesCreator.update(locationCitiesCodigo,locationCitiesUpdate);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/locationCities/"+locationCitiesUpdate.getNombre());
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/{codigo}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("codigo") Long codigo) throws Exception
    {
        locationCitiesCreator.deleteLocationCitiesById(codigo);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/locationCities/"+codigo);
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
}

@Data
final class Request
{
    private Long codigo;
    private String nombre;
}
