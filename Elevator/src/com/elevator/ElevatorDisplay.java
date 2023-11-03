package com.elevator;

public class ElevatorDisplay extends Display{

    public ElevatorDisplay(Elevator elevator) {
        super(elevator);
    }

    @Override
    public void display(){
        if (elevator.isOverloaded()) {
            System.out.println("Elevator is overload.");
        }else {
            super.display();
        }
    }
}
