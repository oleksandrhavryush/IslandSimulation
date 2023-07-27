package org.studyproject.models;

import org.studyproject.simulation.Location;

public class Rabbit extends Animal {
    @Override
    public void eat() {
        System.out.println("Rabbit is eating grass and vegetables.");
    }

    @Override
    public void reproduce() {
        System.out.println("Rabbit is giving birth to baby rabbits.");
    }

    @Override
    public void move() {
        System.out.println("Rabbit is hopping and running.");
    }

    @Override
    public void die() {
        System.out.println("Rabbit has died.");
    }
}

