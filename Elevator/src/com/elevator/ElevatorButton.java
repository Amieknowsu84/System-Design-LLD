package com.elevator;

public class ElevatorButton extends Button{

    int destinationFloor;

    Command command;

    @Override
    public void press() {
        command.execute(new InternalRequest(destinationFloor));
    }
}
