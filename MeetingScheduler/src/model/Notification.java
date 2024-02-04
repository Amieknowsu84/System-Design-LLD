package model;

import java.time.LocalDateTime;

public abstract class Notification {

    private Long id;
    private String content;
    private LocalDateTime createdDateTime;

    protected Notification(Long id) {
        this.id = id;
        this.createdDateTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public void sendNotification(String email){
        System.out.printf("model.Notification [%s] has been received at %s%n", this.content, email);
    }

    public abstract void sendAcceptNotification(User organiser, User user, Meeting meeting);
    public abstract void sendRejectNotification(User organiser, User user, Meeting meeting);
    public abstract void sendInviteNotification(User organiser, User user, Meeting meeting);
    public abstract void sendCancelNotification(User organiser, User user, Meeting meeting);

}
