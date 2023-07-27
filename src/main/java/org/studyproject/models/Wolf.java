package org.studyproject.models;

import org.studyproject.simulation.Location;

public class Wolf extends Animal {
    @Override
    public void eat() {
        System.out.println("Wolf is hunting and eating rabbits and ducks.");
    }

    @Override
    public void reproduce() {
        System.out.println("Wolf is giving birth to wolf cubs.");
    }

    @Override
    public void move() {
        System.out.println("Wolf is running and roaming in the forest.");
    }

    @Override
    public void die() {
        System.out.println("Wolf has died.");
    }
}

