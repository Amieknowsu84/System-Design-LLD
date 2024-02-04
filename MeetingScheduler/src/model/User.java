package model;

public class User {

    private String name;
    private String email;

    private Calender calender;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.calender = new Calender();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calender getCalender() {
        return calender;
    }

    public void setCalender(Calender calender) {
        this.calender = calender;
    }

    public void acceptMeeting(Meeting meeting) {
        meeting.addParticipant(this);
        this.calender.addMeeting(meeting);
        new EmailNotification().sendAcceptNotification(meeting.getOrganizer(), this, meeting);
    }

    public void addMeetingToCalender(Meeting meeting) {
        calender.addMeeting(meeting);
    }

    public void removeMeetingFromCalender(Meeting meeting) {
        calender.removeMeeting(meeting);
    }

    public void rejectMeeting(Meeting meeting) {
        meeting.removeParticipant(this);
        this.calender.removeMeeting(meeting);
        new EmailNotification().sendRejectNotification(meeting.getOrganizer(), this, meeting);
    }

    public void attendMeeting(Meeting meeting) {
        System.out.println(String.format("{} is attending meeting {}", this.email, meeting.getSubject()));
    }



}
