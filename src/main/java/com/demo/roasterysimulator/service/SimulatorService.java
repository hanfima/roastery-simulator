package com.demo.roasterysimulator.service;

import com.demo.roasterysimulator.domain.GreenCoffee;
import com.demo.roasterysimulator.domain.Machine;
import com.demo.roasterysimulator.domain.RoastingFacility;
import com.demo.roasterysimulator.domain.RoastingProcess;
import com.demo.roasterysimulator.repository.dto.MachineWeight;
import com.demo.roasterysimulator.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimulatorService {

    @Autowired
    private FacilityService facilityService;
    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private RoasterService roasterService;
    @Autowired
    private MachineService machineService;

    public void simulate() {
        facilityService.allFacilities().forEach(facility -> {
            coffeeService.getCoffeesByFacility(facility.getId()).forEach(coffee -> {
                roast(facility, coffee);
            });
        });
    }

    public void avgAmountPerMachine() {
        roasterService.avgAmountPerMachine().forEach(average -> {
            System.out.println("Machine: " + average.getMachineId() + " " + average.getMachineName() +
                    " roasted on average: " + average.getAvgWeight() +  " kg");
        });
    }

    private void roast(RoastingFacility facility, GreenCoffee coffee) {
        Machine machine = machineService.getRandomMachine(facility.getId());
        printDetails(facility, machine, coffee);

        int capacity = machine.getCapacity();
        double minCoffeeToRoast = 0.65 * capacity;

        while (hasEnoughCoffeeInWarehouse(coffee.getWeight(), minCoffeeToRoast)) {
            double coffeeToRoast = Utils.generateRandom(minCoffeeToRoast, capacity);

            if(hasEnoughCoffeeToRoast(coffee.getWeight(), coffeeToRoast)) {
                coffeeService.updateCoffeeWeight(coffee, coffeeToRoast);

                RoastingProcess process = roasterService.createProcess(coffeeToRoast, machine, coffee);
                System.out.println(process);
            }
        }
    }

    private boolean hasEnoughCoffeeInWarehouse(double weight, double minCapacity) {
        return weight > minCapacity;
    }

    private boolean hasEnoughCoffeeToRoast(double weight, double coffeeToRoast) {
        return weight > coffeeToRoast;
    }

    private void printDetails(RoastingFacility facility, Machine machine, GreenCoffee coffee) {
        System.out.println("Facility: " + facility.getId() + " " + facility.getName() +
                " with machine: " + machine.getId() + " " + machine.getName() +
                " with " + coffee.getWeight() + " kg of " + coffee.getCountry() + " coffee");
    }

}
