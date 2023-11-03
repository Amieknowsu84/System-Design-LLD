package com.elevator;

public class ElevatorCommand implements Command {

    Elevator elevator;

    @Override
    public void execute(Request request) {
        elevator.processRequest(request);
    }
}
