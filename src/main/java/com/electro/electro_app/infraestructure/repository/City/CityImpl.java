package com.electro.electro_app.infraestructure.repository.City;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electro.electro_app.application.service.ICityService;
import com.electro.electro_app.application.service.ICityService;
import com.electro.electro_app.domain.entities.City;

@Service
public class CityImpl implements ICityService {

    @Autowired
    private CityRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<City> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<City> findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public City save(City city) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<City> update(int id, City city) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Optional<City> delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    

}
