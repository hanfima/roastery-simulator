package com.demo.roasterysimulator.service;

import com.demo.roasterysimulator.domain.GreenCoffee;

import java.util.List;

public interface CoffeeService {

    void addCoffee(GreenCoffee coffee);
    void addCoffees(List<GreenCoffee> coffees);
    List<GreenCoffee> getCoffeesByFacility(long facility);
    GreenCoffee getRandomCoffee(long facility);
    GreenCoffee updateCoffeeWeight(GreenCoffee coffee, double roastedCoffee);
}
