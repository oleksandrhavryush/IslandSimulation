package org.studyproject.simulation;

import org.studyproject.config.SimulationConfig;
import org.studyproject.models.*;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Simulation {
    private Island island;
    private SimulationConfig config;

    public Simulation(SimulationConfig config) {
        this.config = config;
        this.island = new Island(config.getIslandSize(), config.getIslandSize());
        initializeIsland(); // Ініціалізуємо острів з вихідними тваринами та рослинами
    }

    public void run() {
        for (int i = 0; i < config.getSimulationDuration(); i++) {
            // Логіка для росту рослин, життєвого циклу тварин та виведення статистики

            // Виконання завдання росту рослин
            for (int x = 0; x < config.getIslandSize(); x++) {
                for (int y = 0; y < config.getIslandSize(); y++) {
                    Location location = island.getLocation(x, y);
                    List<Plant> plants = location.getPlants();
                    Iterator<Plant> plantIterator = plants.iterator();
                    while (plantIterator.hasNext()) {
                        Plant plant = plantIterator.next();
                        plant.grow();
                    }
                }
            }


            // Виконання завдання життєвого циклу тварин
            for (int x = 0; x < config.getIslandSize(); x++) {
                for (int y = 0; y < config.getIslandSize(); y++) {
                    Location location = island.getLocation(x, y);
                    List<Animal> animals = location.getAnimals();
                    Iterator<Animal> animalIterator = animals.iterator();
                    while (animalIterator.hasNext()) {
                        Animal animal = animalIterator.next();
                        animal.eat();
                        animal.reproduce();
                        animal.move();
                        if (Math.random() < 0.1) {
                            animal.die();
                            animalIterator.remove(); // Видаляємо тварину зі списку за допомогою ітератора
                        }
                    }
                }
            }

            // Виведення статистики
            if (i % 10 == 0) {
                System.out.println("==== Крок симуляції " + i + " ====");
                printStatistics(); // Виводимо статистику на екран
            }
        }
    }

    private void initializeIsland() {
        // Додаємо початкові тварини та рослини на острів
        Random random = new Random();
        for (int i = 0; i < config.getInitialDuckCount(); i++) {
            int x = random.nextInt(config.getIslandSize());
            int y = random.nextInt(config.getIslandSize());
            Location location = island.getLocation(x, y);
            location.addAnimal(new Duck());
        }

        for (int i = 0; i < config.getInitialRabbitCount(); i++) {
            int x = random.nextInt(config.getIslandSize());
            int y = random.nextInt(config.getIslandSize());
            Location location = island.getLocation(x, y);
            location.addAnimal(new Rabbit());
        }

        for (int i = 0; i < config.getInitialWolfCount(); i++) {
            int x = random.nextInt(config.getIslandSize());
            int y = random.nextInt(config.getIslandSize());
            Location location = island.getLocation(x, y);
            location.addAnimal(new Wolf());
        }

        // Додаємо початкові рослини на острів
        for (int x = 0; x < config.getIslandSize(); x++) {
            for (int y = 0; y < config.getIslandSize(); y++) {
                Location location = island.getLocation(x, y);
                location.addPlant(new Plant());
            }
        }
    }

    private void printStatistics() {
        int totalDuckCount = 0;
        int totalRabbitCount = 0;
        int totalWolfCount = 0;
        int totalPlantCount = 0;

        for (int x = 0; x < config.getIslandSize(); x++) {
            for (int y = 0; y < config.getIslandSize(); y++) {
                Location location = island.getLocation(x, y);
                totalDuckCount += countAnimalsOfType(location, Duck.class);
                totalRabbitCount += countAnimalsOfType(location, Rabbit.class);
                totalWolfCount += countAnimalsOfType(location, Wolf.class);
                totalPlantCount += location.getPlants().size();
            }
        }

        System.out.println("Total Ducks: " + totalDuckCount);
        System.out.println("Total Rabbits: " + totalRabbitCount);
        System.out.println("Total Wolves: " + totalWolfCount);
        System.out.println("Total Plants: " + totalPlantCount);
    }

    private int countAnimalsOfType(Location location, Class<? extends Animal> animalType) {
        int count = 0;
        for (Animal animal : location.getAnimals()) {
            if (animalType.isInstance(animal)) {
                count++;
            }
        }
        return count;
    }
}
