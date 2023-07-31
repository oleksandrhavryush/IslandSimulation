package org.oleksandr.entity.organism.animal.herbivore;

import org.junit.jupiter.api.Test;
import org.oleksandr.entity.map.Cell;
import org.oleksandr.entity.organism.plant.Grass;

import static org.junit.jupiter.api.Assertions.*;

public class HerbivoreTest {
    @Test
    public void testHerbivoreEat() {

        // Arrange
        Herbivore herbivore = new Rabbit();
        Grass grass = new Grass();
        Cell cell = new Cell();
        cell.addOrganism(herbivore);
        cell.addOrganism(grass);

        // Act
        herbivore.eat(grass);

        // Assert
        assertFalse(cell.getResidents().get(Grass.class).contains(grass), "Grass should be eaten");
        assertFalse(cell.getResidents().get(Herbivore.class).contains(herbivore), "Herbivore should not eat itself");

    }
}

