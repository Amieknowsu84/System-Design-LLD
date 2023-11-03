package com.elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorPanel {

    private List<ElevatorButton> elevatorButtons;
    private List<UtilityButton> utilityButtons;

    private ElevatorDisplay elevatorDisplay;


    public ElevatorPanel(int noOfFloors) {
        this.elevatorButtons = new ArrayList<>(noOfFloors);
    }

    public List<ElevatorButton> getElevatorButtons() {
        return elevatorButtons;
    }

    public void setElevatorButtons(List<ElevatorButton> elevatorButtons) {
        this.elevatorButtons = elevatorButtons;
    }
}
