package com.demo.roasterysimulator.domain;

import javax.persistence.*;

@Entity
@Table(name = "machine")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name", length = 32)
    private String name;
    @Column(name = "capacity")
    private int capacity;

    public Machine() {
    }

    public Machine(String name, int capacity, RoastingFacility roastingFacility) {
        this.name = name;
        this.capacity = capacity;
        this.roastingFacility = roastingFacility;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    private RoastingFacility roastingFacility;

    @OneToOne(mappedBy = "machine")
    private RoastingProcess roastingProcess;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public RoastingFacility getRoastingFacility() {
        return roastingFacility;
    }

    public RoastingProcess getRoastingProcess() {
        return roastingProcess;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", roastingFacility=" + roastingFacility +
                ", roastingProcess=" + roastingProcess +
                '}';
    }
}
