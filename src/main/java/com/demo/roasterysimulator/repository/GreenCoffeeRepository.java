package com.demo.roasterysimulator.repository;

import com.demo.roasterysimulator.domain.GreenCoffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GreenCoffeeRepository extends JpaRepository<GreenCoffee, Long> {

    List<GreenCoffee> findAllByRoastingFacilityId(long facilityId);
}
