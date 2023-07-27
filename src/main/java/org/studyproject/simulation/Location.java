package org.studyproject.simulation;

import org.studyproject.models.Animal;
import org.studyproject.models.Plant;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private int x;
    private int y;
    private List<Animal> animals;
    private List<Plant> plants;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        this.animals = new ArrayList<>();
        this.plants = new ArrayList<>();
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void removePlant(Plant plant) {
        plants.remove(plant);
    }

    // Тут можна додати інші методи для взаємодії з тваринами та рослинами на локації

}
