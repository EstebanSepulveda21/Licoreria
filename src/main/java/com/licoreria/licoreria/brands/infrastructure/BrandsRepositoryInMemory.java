package com.licoreria.licoreria.brands.infrastructure;

import com.licoreria.licoreria.brands.domain.Brand;
import com.licoreria.licoreria.brands.domain.BrandsRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class BrandsRepositoryInMemory implements BrandsRepository {

    @Override
    public List<Brand> findAll() {
        return null;
    }

    @Override
    public List<Brand> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Brand> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Brand> findAllById(Iterable<BigDecimal> iterable) {
        return null;
    }

    

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(BigDecimal bigDecimal) {

    }

    @Override
    public void delete(Brand brand) {

    }

    @Override
    public void deleteAll(Iterable<? extends Brand> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Brand> S save(S s) {
        return null;
    }

    @Override
    public <S extends Brand> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Brand> findById(BigDecimal bigDecimal) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(BigDecimal bigDecimal) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Brand> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Brand> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Brand getOne(BigDecimal bigDecimal) {
        return null;
    }

    @Override
    public <S extends Brand> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Brand> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Brand> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Brand> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Brand> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Brand> boolean exists(Example<S> example) {
        return false;
    }
}
