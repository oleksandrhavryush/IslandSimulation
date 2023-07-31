package org.oleksandr.entity.organism.animal.predator;

import org.oleksandr.entity.organism.Organism;
import org.oleksandr.entity.organism.animal.Animal;
import org.oleksandr.entity.organism.animal.herbivore.Herbivore;

public class Wolf extends Predator {
    public Wolf() {
        super();
    }

    @Override
    public void eat(Organism organism) {
        if (organism instanceof Animal) {
            System.out.println("I eat " + Herbivore.class.getSimpleName().toLowerCase() + " " + Animal.class.getSimpleName().toLowerCase() + "s");
        } else {
            System.out.println("I can only eat " + Herbivore.class.getSimpleName().toLowerCase() + " " + Animal.class.getSimpleName().toLowerCase() + "s");
        }
    }

    @Override
    public String toString() {
        return "Wolf";
    }
}
