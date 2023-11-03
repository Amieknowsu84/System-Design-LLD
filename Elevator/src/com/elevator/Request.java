package com.elevator;

public abstract class Request {

    public int floor;

    public abstract void process(Elevator elevator);

}
