package com.electro.electro_app.application.service;

import java.util.List;
import java.util.Optional;

import com.electro.electro_app.domain.entities.Region;

public interface IRegionService {
List<Region> findAll();

    Optional<Region> findById(int id);

    Region save(Region region);

    Optional<Region> update(int id, Region region);

    Optional<Region> delete(int id);
}
