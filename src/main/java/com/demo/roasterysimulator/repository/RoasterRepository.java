package com.demo.roasterysimulator.repository;

import com.demo.roasterysimulator.domain.RoastingProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoasterRepository extends JpaRepository<RoastingProcess, Long> {
}
