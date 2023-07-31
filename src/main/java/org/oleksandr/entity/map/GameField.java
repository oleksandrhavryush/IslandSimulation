package org.oleksandr.entity.map;

import org.oleksandr.controller.CellManager;
import org.oleksandr.entity.organism.Organism;
import org.yaml.snakeyaml.Yaml;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameField {private int width;
    private int height;
    private Cell[][] cells;
    CellManager cellManager = new CellManager();

    public GameField() {
        loadGameFieldDataFromYamlFile("C:\\Users\\havry\\IdeaProjects\\IslandSimulation\\src\\main\\resources\\config.yaml");
        cells = new Cell[width][height];
        // Ініціалізуємо кожну клітинку окремо
        initializeCells();
    }

    private void initializeCells() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell();
                cellManager.initializeCell(cells[i][j]);
            }
        }
    }

    private void loadGameFieldDataFromYamlFile(String yamlFilePath) {
        Yaml yaml = new Yaml();
        try (FileReader reader = new FileReader(yamlFilePath)) {
            // Зчитати YAML-документ у мапу
            Object data = yaml.load(reader);
            if (data instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) data;
                Map<String, Object> gameFieldData = (Map<String, Object>) map.get(this.getClass().getSimpleName());
                // Присвоїти значення кожному полю з YAML-файлу
                width = ((Integer) gameFieldData.get("width")).intValue();
                height = ((Integer) gameFieldData.get("height")).intValue();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Обробка помилки завантаження з файлу
            System.out.println("Could not load game field data from file: " + yamlFilePath);
            System.exit(1);
        }
    }

    public String getCellStatistics(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return "Invalid cell coordinates.";
        }

        Cell cell = cells[x][y];
        Map<String, Integer> statistics = new HashMap<>();

        for (List<Organism> organisms : cell.getResidents().values()) {
            for (Organism organism : organisms) {
                String organismName = organism.getClass().getSimpleName();
                statistics.put(organismName, statistics.getOrDefault(organismName, 0) + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        return sb.toString();
    }

    public String getAllCellStatistics() {
        Map<String, Integer> statistics = new HashMap<>();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell cell = cells[i][j];
                for (List<Organism> organisms : cell.getResidents().values()) {
                    for (Organism organism : organisms) {
                        String organismName = organism.getClass().getSimpleName();
                        statistics.put(organismName, statistics.getOrDefault(organismName, 0) + 1);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GameField{")
                .append("width=")
                .append(width)
                .append(", height=")
                .append(height)
                .append(", cells=\n");

        for (Cell[] row : cells) {
            sb.append(Arrays.toString(row))
                    .append("\n");
        }

        sb.append("}");

        return sb.toString();
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