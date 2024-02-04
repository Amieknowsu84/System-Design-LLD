package model;

import java.util.List;
import java.util.stream.Collectors;

public class Meeting {

    private Long id;
    private String subject;
    private String body;
    private MeetingRoom location;
    private Interval interval;
    private List<User> participants;
    private User organizer;


    public Meeting(Long id, String subject, String body, MeetingRoom location, Interval interval, List<User> participants, User organizer) {
        this.id = id;
        this.subject = subject;
        this.body = body;
        this.location = location;
        this.interval = interval;
        this.participants = participants;
        this.organizer = organizer;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    public void addParticipant(User user) {
        this.participants.add(user);
    }

    public void removeParticipant(User user) {
        this.participants.remove(user);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public MeetingRoom getLocation() {
        return location;
    }

    public void setLocation(MeetingRoom location) {
        this.location = location;
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", location= Room-" + location.getId() +
                ", interval=" + interval +
                ", participants=" + getParticipantsName() +
                ", organizer=" + organizer.getName() +
                '}';
    }

    String getParticipantsName(){
        return participants.stream().map(User::getName).collect(Collectors.joining(",","[","]"));
    }
}
