package com.demo.roasterysimulator;

import com.demo.roasterysimulator.domain.GreenCoffee;
import com.demo.roasterysimulator.service.CoffeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class RoasterySimulatorApplicationTests {

	@Autowired
	public CoffeeService coffeeService;

	@Test
	public void testWarehouseLeftovers() {
		GreenCoffee coffee = createCoffee();

		assertEquals(300, coffeeService.updateCoffeeWeight(coffee, 200).getWeight());
		assertEquals(200, coffeeService.updateCoffeeWeight(coffee, 100).getWeight());
		assertEquals(150, coffeeService.updateCoffeeWeight(coffee, 50).getWeight());

	}

	private GreenCoffee createCoffee() {
		GreenCoffee coffee = new GreenCoffee("Columbian", 500.0);
		coffeeService.addCoffee(coffee);
		return coffee;
	}

}
