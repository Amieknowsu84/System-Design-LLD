package com.elevator;

public class InternalRequest extends Request {

    public InternalRequest(int floor){
        this.floor = floor;
    }

    @Override
    public void process(Elevator elevator) {
        int requestedFloor = this.floor;
        int currentFloor = elevator.getCurrentFloor();
        if (requestedFloor > currentFloor) {
            elevator.addUpFloor(requestedFloor);
        } else {
            elevator.addDownFloor(requestedFloor);
        }
    }
}
