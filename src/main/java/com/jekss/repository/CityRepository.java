package com.jekss.repository;

import com.jekss.entityes.City;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by jekss on 11.10.15.
 */
public interface CityRepository extends JpaRepository<City, Integer> {
}
