package com.demo.roasterysimulator.domain;

import javax.persistence.*;

@Entity
@Table(name = "green_coffee")
public class GreenCoffee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "country")
    private String country;
    @Column(name = "weight")
    private double weight; // consider weight as double as value wouldn't be integer after roasting certain amount of coffee

    public GreenCoffee() {
    }

    public GreenCoffee(String country, double weight) {
        this.country = country;
        this.weight = weight;
    }

    public GreenCoffee(String country, double weight, RoastingFacility roastingFacility) {
        this.country = country;
        this.weight = weight;
        this.roastingFacility = roastingFacility;
    }

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private RoastingFacility roastingFacility;

    @OneToOne(mappedBy = "greenCoffee")
    private RoastingProcess roastingProcess;

    public long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public double getWeight() {
        return weight;
    }

    public RoastingFacility getRoastingFacility() {
        return roastingFacility;
    }

    public RoastingProcess getRoastingProcess() {
        return roastingProcess;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "GreenCoffee{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", weight=" + weight +
                ", roastingFacility=" + roastingFacility +
                ", roastingProcess=" + roastingProcess +
                '}';
    }
}
