package com.demo.roasterysimulator.component;

import com.demo.roasterysimulator.domain.GreenCoffee;
import com.demo.roasterysimulator.domain.Machine;
import com.demo.roasterysimulator.domain.RoastingFacility;
import com.demo.roasterysimulator.service.CoffeeService;
import com.demo.roasterysimulator.service.FacilityService;
import com.demo.roasterysimulator.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WarehouseService {

    @Autowired
    private FacilityService facilityService;
    @Autowired
    private MachineService machineService;
    @Autowired
    private CoffeeService coffeeService;

    public void loadWarehouse() {
        addNinjaFacility();
        addAustrianFacility();
        addEcoFacility();
        addPandaFacility();
        addDinoFacility();
    }

    private void addNinjaFacility() {
        RoastingFacility facility = new RoastingFacility("Ninja Facility");
        facilityService.addFacility(facility);

        Machine superHydra = new Machine("SuperHydra", 60, facility);
        Machine kungFu = new Machine("KungFu", 90, facility);

        GreenCoffee brazilian = new GreenCoffee("Brazilian", 500.0, facility);
        GreenCoffee ethiopian = new GreenCoffee("Ethiopian", 800.0, facility);
        GreenCoffee columbian = new GreenCoffee("Columbian", 1500.0, facility);

        coffeeService.addCoffees(List.of(brazilian, ethiopian, columbian));
        machineService.addMachines(List.of(superHydra, kungFu));
    }

    private void addAustrianFacility() {
        RoastingFacility facility = new RoastingFacility("Austrian Facility");
        facilityService.addFacility(facility);

        Machine viennese = new Machine("Viennese Machine", 70, facility);
        Machine tyrolean = new Machine("Tyrolean Machine", 60, facility);
        Machine mozart = new Machine("Mozart Machine", 90, facility);

        GreenCoffee guatemala = new GreenCoffee("Guatemala", 2000.0, facility);
        GreenCoffee arabian = new GreenCoffee("Arabian", 300.0, facility);
        GreenCoffee costaRica = new GreenCoffee("Rican", 500.0, facility);

        coffeeService.addCoffees(List.of(guatemala, arabian, costaRica));
        machineService.addMachines(List.of(viennese, tyrolean, mozart));
    }

    private void addEcoFacility() {
        RoastingFacility facility = new RoastingFacility("Eco Facility");

        Machine ecoMachine = new Machine("Eco Machine", 70, facility);

        GreenCoffee italian = new GreenCoffee("Italian", 400.0, facility);
        GreenCoffee moroccan = new GreenCoffee("Moroccan", 600.0, facility);
        GreenCoffee black = new GreenCoffee("Black", 200.0, facility);

        facilityService.addFacility(facility);
        coffeeService.addCoffees(List.of(italian, moroccan, black));
        machineService.addMachine(ecoMachine);
    }

    private void addPandaFacility() {
        RoastingFacility facility = new RoastingFacility("Panda Facility");

        Machine bamboo = new Machine("Bamboo Machine", 75, facility);

        GreenCoffee jamaican = new GreenCoffee("Jamaican", 700.0, facility);
        GreenCoffee moroccan = new GreenCoffee("Moroccan", 600.0, facility);
        GreenCoffee italian = new GreenCoffee("Italian", 900.0, facility);

        facilityService.addFacility(facility);
        coffeeService.addCoffees(List.of(italian, moroccan, jamaican));
        machineService.addMachine(bamboo);
    }

    private void addDinoFacility() {
        RoastingFacility facility = new RoastingFacility("Dino Facility");

        Machine rex = new Machine("Rex Machine", 80, facility);
        Machine dragon = new Machine("Dragon Machine", 90, facility);

        GreenCoffee brazilian = new GreenCoffee("Brazilian", 1600.0, facility);
        GreenCoffee moroccan = new GreenCoffee("Moroccan", 800.0, facility);
        GreenCoffee ethiopian = new GreenCoffee("Ethiopian", 900.0, facility);

        facilityService.addFacility(facility);
        coffeeService.addCoffees(List.of(brazilian, moroccan, ethiopian));
        machineService.addMachines(List.of(rex, dragon));
    }
}
