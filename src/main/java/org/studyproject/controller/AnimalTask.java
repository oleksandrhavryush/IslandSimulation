package org.studyproject.controller;

import org.studyproject.models.Animal;
import org.studyproject.simulation.Island;
import org.studyproject.simulation.Location;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AnimalTask implements Runnable {

    private final Location location;

    public AnimalTask(Location location) {
        this.location = location;
    }

    @Override
    public void run() {
        List<Animal> animals = location.getAnimals();
        for (Animal animal : animals) {
            animal.move();
            //animal.eat(getRandomOtherAnimal(animals, animal));
            //animal.reproduce(location);
            //animal.die(location);
        }
    }

    // Вибирає випадкову іншу тварину, виключаючи задану тварину
    private Animal getRandomOtherAnimal(List<Animal> animals, Animal currentAnimal) {
        Random random = new Random();
        Animal randomAnimal = currentAnimal;

        while (randomAnimal == currentAnimal) {
            randomAnimal = animals.get(random.nextInt(animals.size()));
        }

        return randomAnimal;
    }
}
