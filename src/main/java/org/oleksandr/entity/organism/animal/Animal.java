package org.oleksandr.entity.organism.animal;

import org.oleksandr.abstraction.entity.Eatable;
import org.oleksandr.entity.organism.Organism;
import org.yaml.snakeyaml.Yaml;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public abstract class Animal extends Organism implements Eatable {
    protected double weightAnimal;
    protected int maxAnimalsPerCell;
    protected int speedAnimal;
    protected double foodNeeded;


    public Animal() {
        // Завантаження значень з YAML-файлу
        loadAnimalDataFromYamlFile("C:\\Users\\havry\\IdeaProjects\\IslandSimulation\\src\\main\\resources\\config.yaml");
    }

    @Override
    public void eat(Organism organism) {
        System.out.println("I can eat");
    }

    // Метод для завантаження даних з YAML-файлу
    private void loadAnimalDataFromYamlFile(String yamlFilePath) {
        Yaml yaml = new Yaml();
        try (FileReader reader = new FileReader(yamlFilePath)) {
            // Зчитати YAML-документ у мапу
            Object data = yaml.load(reader);
            if (data instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) data;
                Map<String, Object> animalData = (Map<String, Object>) map.get(this.getClass().getSimpleName());
                // Присвоїти значення кожному полю з YAML-файлу
                weightAnimal = (double) animalData.get("weightAnimal");
                maxAnimalsPerCell = ((Integer) animalData.get("maxAnimalsPerCell")).intValue();
                speedAnimal = ((Integer) animalData.get("speedAnimal")).intValue();
                foodNeeded = (double) animalData.get("foodNeeded");
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Обробка помилки завантаження з файлу
        }
    }

    public double getWeightAnimal() {
        return weightAnimal;
    }

    public int getMaxAnimalsPerCell() {
        return maxAnimalsPerCell;
    }

    public int getSpeedAnimal() {
        return speedAnimal;
    }

    public double getFoodNeeded() {
        return foodNeeded;
    }

    public void printParameters() {
        System.out.println(this.getClass().getSimpleName() + " Parameters:");
        System.out.println("Weight: " + getWeightAnimal());
        System.out.println("Max Animals per Cell: " + getMaxAnimalsPerCell());
        System.out.println("Speed: " + getSpeedAnimal());
        System.out.println("Food Needed: " + getFoodNeeded());
        System.out.println("\n===================\n");
    }
}
