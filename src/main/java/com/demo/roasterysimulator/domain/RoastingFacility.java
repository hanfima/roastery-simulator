package com.demo.roasterysimulator.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roasting_facility")
public class RoastingFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name", length = 32)
    private String name;

    public RoastingFacility() {
    }

    public RoastingFacility(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "roastingFacility", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Machine> machines = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public List<GreenCoffee> getGreenCoffees() {
        return greenCoffees;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JsonManagedReference
    List<GreenCoffee> greenCoffees = new ArrayList<>();

    @Override
    public String toString() {
        return "RoastingFacility{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", machines=" + machines +
                ", greenCoffees=" + greenCoffees +
                '}';
    }
}
