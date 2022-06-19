package com.demo.roasterysimulator.service;

import com.demo.roasterysimulator.domain.GreenCoffee;
import com.demo.roasterysimulator.repository.GreenCoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class GreenCoffeeService implements CoffeeService {

    @Autowired
    private GreenCoffeeRepository greenCoffeeRepository;

    @Override
    public void addCoffee(GreenCoffee coffee) {
        greenCoffeeRepository.saveAndFlush(coffee);
    }

    @Override
    public void addCoffees(List<GreenCoffee> coffees) {
        greenCoffeeRepository.saveAllAndFlush(coffees);
    }

    @Override
    public List<GreenCoffee> getCoffeesByFacility(long facility) {
        return greenCoffeeRepository.findAllByRoastingFacilityId(facility);
    }

    @Override
    public GreenCoffee getRandomCoffee(long facility) {
        List<GreenCoffee> greenCoffees = greenCoffeeRepository.findAllByRoastingFacilityId(facility);
        return greenCoffees.get(new Random().nextInt(greenCoffees.size()));
    }

    @Override
    public GreenCoffee updateCoffeeWeight(GreenCoffee coffee, double roastedCoffee) {
        coffee.setWeight(coffee.getWeight() - roastedCoffee);
        addCoffee(coffee);
        return coffee;
    }
}
