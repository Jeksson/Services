package com.jekss.service.serv;

import com.jekss.entityes.City;
import com.jekss.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jekss on 12.10.15.
 */
@Service
public class CityServ {

    @Autowired
    private CityRepository cityRepository;

    public City addCity(City city){
        return cityRepository.saveAndFlush(city);
    }
    public void deleteCity(int id){
        cityRepository.delete(id);
    }
    public City getById(int id){
        return cityRepository.findOne(id);
    }

    public City editeCity(City city){
        return cityRepository.saveAndFlush(city);
    }
    public List<City> allCity(){
        return cityRepository.f                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         indAll();
    }
}
