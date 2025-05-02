package com.electro.electro_app.application.service;

import java.util.List;
import java.util.Optional;

import com.electro.electro_app.domain.entities.City;

public interface ICityService {
    List<City> findAll();

    Optional<City> findById(int id);

    City save(City city);

    Optional<City> update(int id, City city);

    Optional<City> delete(int id);
}
