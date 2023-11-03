package com.elevator;

import java.util.PriorityQueue;

public class Elevator {

    private String elevatorId;

    private int capacity;

    private Door door;
    private State state;

    private Direction direction;

    private int currentFloor;

    private ElevatorPanel elevatorPanel;

    private int currentLoad;

    private PriorityQueue<Integer> upQueue;

    private PriorityQueue<Integer> downQueue;

    public void addUpFloor(int floor){
        upQueue.add(floor);
    }

    public void addDownFloor(int floor){
        downQueue.add(floor);
    }


    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(String elevatorId) {
        this.elevatorId = elevatorId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ElevatorPanel getElevatorPanel() {
        return elevatorPanel;
    }

    public void setElevatorPanel(ElevatorPanel elevatorPanel) {
        this.elevatorPanel = elevatorPanel;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(int currentLoad) {
        this.currentLoad = currentLoad;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public boolean isOverloaded(){
        return this.currentLoad > capacity;
    }

    public void processRequest(Request request){
        request.process(this);
    }

    public void startElevator(){
        while (true){
            if (this.state.equals(State.MOVING)){
                if (this.direction.equals(Direction.UP)){
                    while (!upQueue.isEmpty()) {
                        int currentPosition = this.currentFloor;
                        int requestedFloor = upQueue.poll();
                        for (int i = currentPosition; i <= requestedFloor; i++) {
                            this.currentFloor = i;
                            display(i, requestedFloor, Direction.UP);
                        }
                    }
                }else {
                    while (!downQueue.isEmpty()) {
                        int currentPosition = this.currentFloor;
                        int requestedFloor = downQueue.poll();
                        for (int i = currentPosition; i >= requestedFloor; i--) {
                            this.currentFloor = i;
                            display(i, requestedFloor, Direction.DOWN);
                        }
                    }
                }
                if (upQueue.isEmpty() && downQueue.isEmpty()){
                    this.state = State.IDLE;
                }
            }else {
                System.out.println("Floor -> " + this.currentFloor);
            }
        }
    }

    public void display(int floor, int requestedFloor, Direction direction){
        if (floor == requestedFloor){
            System.out.println("Requested floor -> " + requestedFloor);
        }else {
            System.out.println("Floor -> " + requestedFloor + " Direction -> " + direction);
        }
    }


}
