package com.elevator;

public class HallButton extends Button{

    private int sourceFloor;

    private boolean isUp;
    private Command command;

    public HallButton(int floor){
        this.sourceFloor = floor;
    }

    @Override
    public void press() {
        command.execute(new ExternalRequest(sourceFloor, isUp ? Direction.UP : Direction.DOWN));
    }
}
