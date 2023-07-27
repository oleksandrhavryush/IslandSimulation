package org.studyproject.controller;

import org.studyproject.simulation.Island;

public class StatisticsTask implements Runnable {
    private Island island;

    public StatisticsTask(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        // Логіка для виконання задачі збору статистики та виведення її на екран
    }
}
