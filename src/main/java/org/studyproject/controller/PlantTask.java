package org.studyproject.controller;

import org.studyproject.models.Plant;
import org.studyproject.simulation.Island;
import org.studyproject.simulation.Location;

import java.util.List;

public class PlantTask implements Runnable {

    private final Location location;

    public PlantTask(Location location) {
        this.location = location;
    }

    @Override
    public void run() {
        location.getPlants().forEach(plant -> plant.grow());
    }
}
