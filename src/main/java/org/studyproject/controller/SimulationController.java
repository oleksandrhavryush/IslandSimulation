package org.studyproject.controller;

import org.studyproject.config.SimulationConfig;
import org.studyproject.simulation.Island;
import org.studyproject.simulation.Location;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



public class SimulationController {
    private final Island island;
    private final ScheduledExecutorService executorService;

    public SimulationController(Island island) {
        this.island = island;
        this.executorService = Executors.newScheduledThreadPool(3);
    }

    public void startSimulation() {
        int initialDelay = 0;
        int period = 1; // Інтервал між кожним кроком симуляції (у секундах)

        // Запускаємо задачі для росту рослин, життєвого циклу тварин і виведення статистики
        executorService.scheduleAtFixedRate(new PlantTask(island.getLocation(0, 0)), initialDelay, period, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new AnimalTask(island.getLocation(0, 0)), initialDelay, period, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new StatisticsTask(island), initialDelay, period, TimeUnit.SECONDS);
    }

    public void stopSimulation() {
        executorService.shutdown();
    }

}
