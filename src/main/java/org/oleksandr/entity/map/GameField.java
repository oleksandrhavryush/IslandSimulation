package org.oleksandr.entity.map;

import org.yaml.snakeyaml.Yaml;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class GameField {
    private int width;
    private int height;
    Cell[][] cells = new Cell[width][height];

    public GameField() {
        loadGameFieldDataFromYamlFile("C:\\Users\\havry\\IdeaProjects\\IslandSimulation\\src\\main\\resources\\config.yaml");
    }

    private void loadGameFieldDataFromYamlFile(String yamlFilePath) {
        Yaml yaml = new Yaml();
        try (FileReader reader = new FileReader(yamlFilePath)) {
            // Зчитати YAML-документ у мапу
            Object data = yaml.load(reader);
            if (data instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) data;
                Map<String, Object> animalData = (Map<String, Object>) map.get(this.getClass().getSimpleName());
                // Присвоїти значення кожному полю з YAML-файлу
                width = ((Integer) animalData.get("width")).intValue();
                height = ((Integer) animalData.get("height")).intValue();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Обробка помилки завантаження з файлу
        }
    }

    @Override
    public String toString() {
        return "GameField{" +
                "width=" + width +
                ", height=" + height +
                ", cells=" + Arrays.toString(cells) +
                '}';
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell[][] getCells() {
        return cells;
    }
}
