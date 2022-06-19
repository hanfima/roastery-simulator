package com.demo.roasterysimulator;

import com.demo.roasterysimulator.component.WarehouseService;
import com.demo.roasterysimulator.service.SimulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoasterySimulatorApplication implements CommandLineRunner {

	@Autowired
	private WarehouseService warehouseService;
	@Autowired
	private SimulatorService simulatorService;

	public static void main(String[] args) {
		SpringApplication.run(RoasterySimulatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("I am the roaster simulator");
		warehouseService.loadWarehouse();
		simulatorService.simulate();
		simulatorService.avgAmountPerMachine();
	}
}
