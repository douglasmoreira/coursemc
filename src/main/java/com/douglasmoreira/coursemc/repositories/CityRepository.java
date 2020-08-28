package com.douglasmoreira.coursemc.repositories;

import com.douglasmoreira.coursemc.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
