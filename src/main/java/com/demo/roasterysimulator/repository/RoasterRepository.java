package com.demo.roasterysimulator.repository;

import com.demo.roasterysimulator.domain.RoastingProcess;
import com.demo.roasterysimulator.repository.dto.MachineWeight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoasterRepository extends JpaRepository<RoastingProcess, Long> {

    @Query(value = "SELECT AVG(p.weight) as avgWeight, p.process_machine_id as machineId, m.name as machineName " +
            "FROM roasting_process p " +
            "INNER JOIN machine m ON m.id = p.process_machine_id " +
            "GROUP BY p.process_machine_id", nativeQuery = true)
    public List<MachineWeight> getAverageWeightPerMachine();
}
