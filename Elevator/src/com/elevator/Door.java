package com.elevator;

public class Door {

    private boolean isOpen;

    public void close(){
        this.isOpen = false;
    }

    public void open(){
        this.isOpen = true;
    }

    public boolean isOpen(){
        return isOpen;
    }

}
