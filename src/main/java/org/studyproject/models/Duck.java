package org.studyproject.models;

public class Duck extends Animal{
    @Override
    public void eat() {
        System.out.println("Duck is eating aquatic plants and insects.");
    }

    @Override
    public void reproduce() {
        System.out.println("Duck is laying eggs.");
    }

    @Override
    public void move() {
        System.out.println("Duck is swimming and flying.");
    }

    @Override
    public void die() {
        System.out.println("Duck has died.");
    }
}
