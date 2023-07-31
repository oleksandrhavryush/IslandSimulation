package org.oleksandr.entity.organism.plant;

import org.oleksandr.entity.organism.Organism;
import org.yaml.snakeyaml.Yaml;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public abstract class Plant extends Organism {
    protected double weightPlant;
    protected int maxPlantsPerCell;

    public Plant() {
        // Завантаження значень з YAML-файлу
        loadPlantDataFromYamlFile("C:\\Users\\havry\\IdeaProjects\\IslandSimulation\\src\\main\\resources\\config.yaml");
    }

    private void loadPlantDataFromYamlFile(String yamlFilePath) {
        Yaml yaml = new Yaml();
        try (FileReader reader = new FileReader(yamlFilePath)) {
            // Зчитати YAML-документ у мапу
            Object data = yaml.load(reader);
            if (data instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) data;
                Map<String, Object> animalData = (Map<String, Object>) map.get(this.getClass().getSimpleName());
                // Присвоїти значення кожному полю з YAML-файлу
                weightPlant = (double) animalData.get("weightPlant");
                maxPlantsPerCell = ((Integer) animalData.get("maxPlantsPerCell")).intValue();
            }
        } catch (IOException e) {

            e.printStackTrace();
            // Обробка помилки завантаження з файлу
        }
    }

    public double getWeightPlant() {
        return weightPlant;
    }

    public int getMaxPlantsPerCell() {
        return maxPlantsPerCell;
    }
}
