package com.elevator;

public class HallPanel {

    private HallButton up;
    private HallButton down;

    private Display display;

    public HallPanel(int floor){
        up = new HallButton(floor);
        down = new HallButton(floor);
    }

    public HallButton getUp() {
        return up;
    }

    public void setUp(HallButton up) {
        this.up = up;
    }

    public HallButton getDown() {
        return down;
    }

    public void setDown(HallButton down) {
        this.down = down;
    }
}
