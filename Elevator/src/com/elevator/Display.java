package com.elevator;

public class Display {

    Elevator elevator;

    public Display(Elevator elevator){
        this.elevator = elevator;
    }

    public void display(){
        if (!State.IDLE.equals(this.elevator.getState())) {
            System.out.println("Elevator current floor is : " + this.elevator.getCurrentFloor() + " and director : " + this.elevator.getState());
        }
    }

}
