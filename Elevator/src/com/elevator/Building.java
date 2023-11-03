package com.elevator;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private List<Floor> floors;
    private List<Elevator> elevators;

    public Building(List<Floor> floors, List<Elevator> elevators) {
        validateFloors(floors, elevators);
        this.elevators = new ArrayList<>(elevators);
        this.floors = new ArrayList<>(floors);
    }

    private void validateFloors(List<Floor> floors, List<Elevator> elevators) {
        int size = floors.size();
        for (Elevator elevator : elevators) {
            int buttons = elevator.getElevatorPanel().getElevatorButtons().size();
            if (buttons > size) throw new RuntimeException("Number of elevator buttons are greater than floors.");
        }
    }


}
