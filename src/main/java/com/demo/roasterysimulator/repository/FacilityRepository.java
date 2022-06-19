package com.demo.roasterysimulator.repository;

import com.demo.roasterysimulator.domain.RoastingFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<RoastingFacility, Long> {
}
