package com.demo.roasterysimulator.domain;

import javax.persistence.*;

@Entity
@Table(name = "roasting_process")
public class RoastingProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "weight")
    private double weight;
    @Column(name = "duration")
    private int duration;


    public RoastingProcess() {
    }

    public RoastingProcess(double weight, int duration, Machine machine, GreenCoffee greenCoffee) {
        this.weight = weight;
        this.duration = duration;
        this.machine = machine;
        this.greenCoffee = greenCoffee;
    }

    @OneToOne //one process can have only machine
    @JoinColumn(name = "process_machine_id", referencedColumnName = "id")
    private Machine machine;

    @OneToOne
    @JoinColumn(name = "processCoffee", referencedColumnName = "id")
    private GreenCoffee greenCoffee;

    public double getWeight() {
        return weight;
    }

    public int getDuration() {
        return duration;
    }

    public Machine getMachine() {
        return machine;
    }

    public GreenCoffee getGreenCoffee() {
        return greenCoffee;
    }
}
