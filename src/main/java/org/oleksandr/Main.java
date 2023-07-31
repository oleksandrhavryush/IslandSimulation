package org.oleksandr;

import org.oleksandr.controller.HerbivoreController;
import org.oleksandr.entity.map.GameField;
import org.oleksandr.entity.organism.animal.herbivore.Rabbit;

public class Main {
    public static void main(String[] args) {
        GameField gameField = new GameField();
        Rabbit rabbit = new Rabbit();

        int x = 0;
        int y = 0;
        String cellStatistics = gameField.getCellStatistics(x, y);
        System.out.println("Statistics for cell at position (" + x + ", " + y + "):");
        System.out.println(cellStatistics);

        // Get overall statistics for all cells
        String allCellStatistics = gameField.getAllCellStatistics();
        System.out.println("Overall statistics for all cells:");
        System.out.println(allCellStatistics);

        // Викликати метод для їжі травоядних
        HerbivoreController.letHerbivoresEat(gameField.getCells());

        String cellStatisticsUpdate = gameField.getCellStatistics(x, y);
        System.out.println("Statistics for cell at position (" + x + ", " + y + "):");
        System.out.println(cellStatisticsUpdate);

        String allCellStatisticsUpdate = gameField.getAllCellStatistics();
        System.out.println("Overall statistics for all cells:");
        System.out.println(allCellStatisticsUpdate);

    }
}