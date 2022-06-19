package com.demo.roasterysimulator.repository;

import com.demo.roasterysimulator.domain.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Long> {

    List<Machine> findAllByRoastingFacilityId(long facility);
}
