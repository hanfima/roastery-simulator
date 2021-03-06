package com.demo.roasterysimulator.service;

import com.demo.roasterysimulator.domain.Machine;
import com.demo.roasterysimulator.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public void addMachine(Machine machine) {
        machineRepository.saveAndFlush(machine);
    }

    public void addMachines(List<Machine> machines) {
        machineRepository.saveAllAndFlush(machines);
    }

    public Machine getRandomMachine(long facility) {
        List<Machine> machines = machineRepository.findAllByRoastingFacilityId(facility);
        return machines.get(new Random().nextInt(machines.size()));
    }
}
