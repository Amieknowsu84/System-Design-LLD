package model;

import java.util.random.RandomGenerator;

public class EmailNotification extends Notification {

    public EmailNotification() {
        super(RandomGenerator.getDefault().nextLong());
    }

    @Override
    public void sendAcceptNotification(User organiser, User user, Meeting meeting) {
            this.setContent(String.format("model.Meeting %s has been accepted by %s", meeting.getSubject(), user.getEmail()));
            this.sendNotification(organiser.getEmail());
    }

    @Override
    public void sendRejectNotification(User organiser, User user, Meeting meeting) {
        this.setContent(String.format("model.Meeting %s has been rejected by %s", meeting.getSubject(), user.getEmail()));
        this.sendNotification(organiser.getEmail());
    }

    @Override
    public void sendInviteNotification(User organiser, User user, Meeting meeting) {
        this.setContent(String.format("You are invited to %s by %s", meeting.getSubject(), organiser.getEmail()));
        this.sendNotification(user.getEmail());
    }

    @Override
    public void sendCancelNotification(User organiser, User user, Meeting meeting) {
        this.setContent(String.format("model.Meeting %s has been cancelled by %s}", meeting.getSubject(), organiser.getEmail()));
        this.sendNotification(user.getEmail());
    }
}
