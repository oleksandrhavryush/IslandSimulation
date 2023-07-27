package org.studyproject.simulation;


public class Island {
    private Location[][] locations;

    public Island(int rows, int columns) {
        this.locations = new Location[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                locations[i][j] = new Location(i, j);
            }
        }
    }

    public Location getLocation(int x, int y) {
        return locations[x][y];
    }

    // Тут можна додати інші методи для взаємодії з локаціями на острові
}
