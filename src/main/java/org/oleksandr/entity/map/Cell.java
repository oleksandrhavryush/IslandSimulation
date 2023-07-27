package org.oleksandr.entity.map;

import org.oleksandr.entity.organism.Organism;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

public class Cell {
    private final Map<Type, Set<Organism>> residents;

    public Cell(Map<Type, Set<Organism>> residents) {
        this.residents = residents;
    }

    public Map<Type, Set<Organism>> getResidents() {
        return residents;
    }
}
