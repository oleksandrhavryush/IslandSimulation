package org.oleksandr.entity.organism.animal.herbivore;

import org.oleksandr.entity.map.Cell;
import org.oleksandr.entity.map.GameField;
import org.oleksandr.entity.organism.Organism;
import org.oleksandr.entity.organism.animal.Animal;
import org.oleksandr.entity.organism.plant.Grass;

public abstract class Herbivore extends Animal {
    GameField gameField;
    Cell cell;

    public Herbivore() {
        super();
    }

    @Override
    public void eat(Organism organism) {
        if (organism instanceof Grass) {
            //Cell cell = new Cell();
            System.out.println("I eat " + Grass.class.getSimpleName().toLowerCase());
            // Видаляємо траву зі списку жителів клітинки
            if (cell != null && cell.getResidents().containsKey(Grass.class)) {
                cell.removeOrganism(organism, Grass.class);
            }
        } else {
            System.out.println("I can only eat " + Grass.class.getSimpleName().toLowerCase());
        }
    }
}
