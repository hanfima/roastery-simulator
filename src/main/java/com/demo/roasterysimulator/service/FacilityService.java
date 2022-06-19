package com.demo.roasterysimulator.service;

import com.demo.roasterysimulator.domain.RoastingFacility;
import com.demo.roasterysimulator.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService {
    @Autowired
    private FacilityRepository facilityRepository;

    public void addFacility(RoastingFacility facility) {
        facilityRepository.saveAndFlush(facility);
    }

    public List<RoastingFacility> allFacilities() {
        return facilityRepository.findAll();
    }
}
