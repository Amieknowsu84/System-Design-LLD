package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calender {

    List<Meeting> meetings;

    public Calender(){
        this.meetings = new ArrayList<>();
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    public void addMeeting(Meeting meeting){
        this.meetings.add(meeting);
    }

    public void removeMeeting(Meeting meeting){
        this.meetings.remove(meeting);
    }

    @Override
    public String toString() {
        return "Calender{" +
                "meetings=" + getMeetingsByJoin() +
                '}';
    }

    String getMeetingsByJoin(){
        return meetings.stream().map(Meeting::toString).collect(Collectors.joining(", \n","[","]"));
    }
}
