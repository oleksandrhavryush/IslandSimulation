package org.studyproject;

import org.studyproject.config.SimulationConfig;
import org.studyproject.controller.SimulationController;
import org.studyproject.simulation.Island;
import org.studyproject.simulation.Simulation;

public class Main {
    public static void main(String[] args) {
        // Створюємо об'єкт класу SimulationConfig і задаємо параметри симуляції
        SimulationConfig config = new SimulationConfig();
        config.setIslandSize(10); // Розмір острова 10x10
        config.setSimulationDuration(100); // Тривалість симуляції - 100 тактів
        config.setInitialDuckCount(5); // Початкова кількість качок - 5
        config.setInitialRabbitCount(10); // Початкова кількість кроликів - 10
        config.setInitialWolfCount(3); // Початкова кількість вовків - 3

        // Створюємо об'єкт класу Simulation з використанням цієї конфігурації
        Simulation simulation = new Simulation(config);

        // Запускаємо симуляцію
        simulation.run();
    }
}