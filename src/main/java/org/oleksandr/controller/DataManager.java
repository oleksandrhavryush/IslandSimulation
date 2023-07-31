package org.oleksandr.controller;

import org.oleksandr.entity.organism.Organism;
import org.oleksandr.entity.organism.animal.herbivore.Rabbit;
import org.oleksandr.entity.organism.animal.predator.Wolf;
import org.oleksandr.entity.organism.plant.Grass;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    public List<Organism> createAllOrganisms() {
        List<Organism> allOrganisms = new ArrayList<>();
        allOrganisms.add(new Grass());
        allOrganisms.add(new Rabbit());
        allOrganisms.add(new Wolf());

        return allOrganisms;

    }

}
