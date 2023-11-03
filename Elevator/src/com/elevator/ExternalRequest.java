package com.elevator;

public class ExternalRequest extends Request {

    Direction direction;

    public ExternalRequest(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    @Override
    public void process(Elevator elevator) {
        if (elevator.getDirection().equals(direction)) {
            if (direction.equals(Direction.UP)) elevator.addUpFloor(this.floor);
            else elevator.addDownFloor(this.floor);
        } else {
            if (direction.equals(Direction.DOWN)) elevator.addUpFloor(this.floor);
            else elevator.addDownFloor(this.floor);
        }
    }
}
