package com.demo.roasterysimulator.service;

import com.demo.roasterysimulator.domain.GreenCoffee;
import com.demo.roasterysimulator.repository.GreenCoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
