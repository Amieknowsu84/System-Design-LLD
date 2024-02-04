package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class MeetingRoom {

    private static final AtomicLong nextId = new AtomicLong(1);
    private Long id;
    private String name;
    private Integer capacity;
    private List<Interval> intervals;

    public MeetingRoom(String name, Integer capacity) {
        this.id = nextId.getAndIncrement();
        this.name = name;
        this.capacity = capacity;
        this.intervals = new ArrayList<>();
    }

    public void addInterval(Interval interval){
            this.intervals.add(interval);
    }

    public void removeInterval(Interval interval){
        this.intervals.remove(interval);
    }

    public boolean isAvailable(Interval interval, int capacity){
        if (capacity > this.capacity){
            System.out.println("model.Room has lower capacity.");
            return false;
        }
        return !isOverlap(interval, this.intervals);
    }

    private boolean isOverlap(Interval intervalInput, List<Interval> intervals){
        for (Interval interval : intervals) {
            return interval.getStart().isBefore(intervalInput.getEnd()) && intervalInput.getStart().isBefore(interval.getEnd());
        }
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Interval> getIntervals() {
        return intervals;
    }

    public void setIntervals(List<Interval> intervals) {
        this.intervals = intervals;
    }
}
