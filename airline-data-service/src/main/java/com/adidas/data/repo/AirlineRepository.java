package com.adidas.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.adidas.data.model.Airline;

@Repository
public interface AirlineRepository extends CrudRepository<Airline, Integer> {
}
