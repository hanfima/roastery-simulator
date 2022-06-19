package com.demo.roasterysimulator.service;

import com.demo.roasterysimulator.domain.GreenCoffee;
import com.demo.roasterysimulator.domain.Machine;
import com.demo.roasterysimulator.domain.RoastingProcess;
import com.demo.roasterysimulator.repository.RoasterRepository;
import com.demo.roasterysimulator.repository.dto.MachineWeight;
import com.demo.roasterysimulator.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoasterService {

    @Autowired
    private RoasterRepository roasterRepository;

    public RoastingProcess createProcess(double roastedCoffee, Machine machine, GreenCoffee coffee) {
        RoastingProcess process = new RoastingProcess(roastedCoffee, Utils.generateRandom(600, 900), machine, coffee);
        roasterRepository.saveAndFlush(process);
        return process;
    }

    public List<MachineWeight> avgAmountPerMachine() {
        return roasterRepository.getAverageWeightPerMachine();
    }
}
