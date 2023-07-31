package org.oleksandr.controller;

import org.oleksandr.entity.map.Cell;
import org.oleksandr.entity.organism.Organism;
import org.oleksandr.entity.organism.animal.Animal;
import org.oleksandr.entity.organism.plant.Plant;

import java.util.*;

public class CellManager {

    public void initializeCell(Cell cell) {
        // Створюємо список всіх можливих типів організмів.
        List<Organism> allOrganisms = createAllOrganisms();
        // Вибираємо випадково підмножину з цього списку.
        List<Organism> selectedOrganisms = selectRandomSubset(allOrganisms);
        // Додаємо випадкову кількість організмів кожного типу до комірки.
        addRandomCountOfEachType(cell, selectedOrganisms);
    }

    // Цей метод створює список всіх можливих типів організмів, використовуючи DataManager.
    private List<Organism> createAllOrganisms() {
        DataManager dataManager = new DataManager();
        return dataManager.createAllOrganisms();
    }

    // Цей метод вибирає випадково підмножину з заданого списку організмів, використовуючи 50% ймовірність для кожного елемента.
    private List<Organism> selectRandomSubset(List<Organism> organisms) {
        Random random = new Random();
        List<Organism> selected = new ArrayList<>();
        for (Organism organism : organisms) {
            if (random.nextBoolean()) {
                selected.add(organism);
            }
        }
        return selected;
    }

    //  Цей метод додає випадкову кількість організмів кожного типу до заданої комірки, використовуючи максимальну кількість для кожного типу.
    private void addRandomCountOfEachType(Cell cell, List<Organism> organisms) {
        Random random = new Random();
        for (Organism organism : organisms) {
            // Коментар: Отримуємо максимальну кількість організмів даного типу в комірці.
            int maxCount = getMaxOrganismCount(organism);
            // Коментар: Генеруємо випадкову кількість від 0 до максимальної.
            int count = random.nextInt(maxCount + 1);
            // Коментар: Додаємо цю кількість організмів до комірки.
            for (int i = 0; i < count; i++) {
                cell.addOrganism(organism);
            }
        }
    }

    private int getMaxOrganismCount(Organism organism) {
        if (organism instanceof Animal) {
            return ((Animal) organism).getMaxAnimalsPerCell();
        } else if (organism instanceof Plant) {
            return ((Plant) organism).getMaxPlantsPerCell();
        } else {
            // Якщо інший тип організму, поверніть значення за замовчуванням
            return 1;
        }
    }
}
