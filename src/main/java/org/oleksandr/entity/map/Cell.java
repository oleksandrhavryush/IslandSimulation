package org.oleksandr.entity.map;

import org.oleksandr.entity.organism.Organism;

import java.util.*;

public class Cell {
    private final Map<Class<? extends Organism>, List<Organism>> residents;

    public Cell() {
        this.residents = new HashMap<>();
    }

    public void addOrganism(Organism organism) {
        Class<? extends Organism> organismClass = organism.getClass();
        residents.computeIfAbsent(organismClass, k -> new ArrayList<>()).add(organism);
    }

    public void removeOrganism(Organism organism, Class<? extends Organism> organismClass) {
        List<Organism> organisms = residents.get(organismClass);
        if (organisms != null) {
            organisms.remove(organism);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return Objects.equals(residents, cell.residents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(residents);
    }

    public Map<Class<? extends Organism>, List<Organism>> getResidents() {
        return residents;
    }

    @Override
    public String toString() {
        return "Cell{residents=" + residents.values() + "}";
    }
}
