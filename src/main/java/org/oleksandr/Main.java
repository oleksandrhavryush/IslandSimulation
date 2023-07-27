package org.oleksandr;

import org.oleksandr.entity.map.GameField;
import org.oleksandr.entity.organism.animal.herbivore.Rabbit;
import org.oleksandr.entity.organism.animal.predator.Wolf;
import org.oleksandr.entity.organism.plant.Grass;

public class Main {
    public static void main(String[] args) {
        GameField gameField = new GameField();
        System.out.println(gameField);

        Grass grass = new Grass();
        Rabbit rabbit = new Rabbit();
        rabbit.eat(grass);
        rabbit.printParameters();

        Wolf wolf = new Wolf();
        wolf.eat(rabbit);
        wolf.printParameters();


    }
}