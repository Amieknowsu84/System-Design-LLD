package com.elevator;

public class Floor {

    private HallPanel hallPanel;
    private boolean isHighestFloor;

    private boolean isLowestFloor;

    private Floor(HallPanel hallPanel, Display display) {
        this.hallPanel = hallPanel;
    }

    public static Floor createFloor(HallPanel hallPanel, Display display) {
        return new Floor(hallPanel, display);
    }

    public static Floor createHighestFloor(HallPanel hallPanel, Display display) {
        Floor heigheshtFloor = new Floor(hallPanel, display);
        heigheshtFloor.isHighestFloor = true;
        return heigheshtFloor;
    }

    public static Floor createLowestFloor(HallPanel hallPanel, Display display) {
        Floor lowestFloor = new Floor(hallPanel, display);
        lowestFloor.isLowestFloor = true;
        return lowestFloor;
    }

}
