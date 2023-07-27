package org.studyproject.models;

import org.studyproject.simulation.Location;

public abstract class Animal {
    private int age;
    private String gender;
    private boolean isAlive;

    public abstract void eat();
    public abstract void reproduce();
    public abstract void move();
    public abstract void die();
}

