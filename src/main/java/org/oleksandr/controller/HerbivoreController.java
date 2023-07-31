package org.oleksandr.controller;

import org.oleksandr.entity.map.Cell;
import org.oleksandr.entity.organism.Organism;
import org.oleksandr.entity.organism.animal.herbivore.Herbivore;
import org.oleksandr.entity.organism.plant.Grass;

import java.util.Iterator;
import java.util.List;

public class HerbivoreController {
    public static void letHerbivoresEat(Cell[][] cells) {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                letHerbivoresEatInCell(cell);
            }
        }
    }

    private static void letHerbivoresEatInCell(Cell cell) {
        List<Organism> herbivores = cell.getResidents().get(Herbivore.class);
        if (herbivores != null) {
            Iterator<Organism> iterator = herbivores.iterator();
            while (iterator.hasNext()) {
                Organism herbivore = iterator.next();
                if (herbivore instanceof Herbivore) {
                    Herbivore herbivoreObj = (Herbivore) herbivore;
                    List<Organism> grassList = cell.getResidents().get(Grass.class);
                    if (!grassList.isEmpty()) {
                        Organism grass = grassList.get(0);//Assuming the first grass is eaten
                        herbivoreObj.eat(grass);
                        grassList.remove(0);//Remove the eaten grass from the list
                        cell.removeOrganism(grass, Grass.class);//Remove the eaten grass from the cell
                    } else {
                        System.out.println("There is no grass to eat in this cell.");
                    }
                }
            }
        }
    }
}



