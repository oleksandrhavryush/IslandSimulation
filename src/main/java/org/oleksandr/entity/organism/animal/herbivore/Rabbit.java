package org.oleksandr.entity.organism.animal.herbivore;

import org.oleksandr.entity.organism.Organism;
import org.oleksandr.entity.organism.plant.Grass;

public class Rabbit extends Herbivore {

    @Override
    public void eat(Organism organism) {
        if (organism instanceof Grass) {
            System.out.println("I eat " + Grass.class.getSimpleName().toLowerCase());
        } else {
            System.out.println("I can only eat " + Grass.class.getSimpleName().toLowerCase());
        }
    }

    public Rabbit() {
        super();
    }
}
