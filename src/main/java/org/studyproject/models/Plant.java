package org.studyproject.models;

public class Plant {
    private double weight;
    private int maxPerCell;

    public void grow() {
        // Приріст кількості рослин залежить від ваги і максимальної кількості на клітинці
        int newPlants = (int) (weight * 0.1);
        if (newPlants > maxPerCell) {
            newPlants = maxPerCell;
        }
        System.out.println("New plants have grown: " + newPlants);
    }
}
