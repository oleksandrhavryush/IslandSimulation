package org.studyproject.config;


public class SimulationConfig {
    // Параметри симуляції
    private int islandSize;
    private int simulationDuration;
    private int initialDuckCount;
    private int initialRabbitCount;
    private int initialWolfCount;

    public int getIslandSize() {
        return islandSize;
    }

    public void setIslandSize(int islandSize) {
        this.islandSize = islandSize;
    }

    public int getSimulationDuration() {
        return simulationDuration;
    }

    public void setSimulationDuration(int simulationDuration) {
        this.simulationDuration = simulationDuration;
    }

    public int getInitialDuckCount() {
        return initialDuckCount;
    }

    public void setInitialDuckCount(int initialDuckCount) {
        this.initialDuckCount = initialDuckCount;
    }

    public int getInitialRabbitCount() {
        return initialRabbitCount;
    }

    public void setInitialRabbitCount(int initialRabbitCount) {
        this.initialRabbitCount = initialRabbitCount;
    }

    public int getInitialWolfCount() {
        return initialWolfCount;
    }

    public void setInitialWolfCount(int initialWolfCount) {
        this.initialWolfCount = initialWolfCount;
    }
// Додайте геттери та сеттери для всіх параметрів
}

