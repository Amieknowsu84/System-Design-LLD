package model;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class MeetingScheduler {
    private static volatile MeetingScheduler meetingScheduler;
    private final List<MeetingRoom> rooms;

    private final Notification notification;

    private static final AtomicLong nextMeetingId = new AtomicLong(1);

    private MeetingScheduler(List<MeetingRoom> rooms, Notification notification) {
        this.rooms = rooms;
        this.notification = notification;
    }

    public static MeetingScheduler getInstance(List<MeetingRoom> rooms, Notification notification) {
        if (meetingScheduler == null) {
            synchronized (MeetingScheduler.class) {
                if (meetingScheduler == null) {
                    meetingScheduler = new MeetingScheduler(rooms, notification);
                }
            }
        }
        return meetingScheduler;
    }

    public Optional<Meeting> scheduleMeeting(Interval interval, List<User> participants, User organizer, String subject, String body) {
        if (participants.size() <= 1) {
            System.out.println("Insufficient participants.");
            return Optional.empty();
        }

        Optional<MeetingRoom> room = checkRoomsAvailability(participants.size(), interval);
        if (room.isEmpty()) {
            System.out.println("model.Room is not available.");
            return Optional.empty();
        }

        Meeting meeting = new Meeting(nextMeetingId.getAndIncrement(),subject, body,
                room.get(), interval, participants, organizer);

        bookRoom(room.get(), interval);

        participants.forEach((participant) -> {
                participant.addMeetingToCalender(meeting);
                notification.sendInviteNotification(organizer, participant, meeting);
        });

        return Optional.of(meeting);
    }

    public void cancelMeeting(Meeting meeting) {
        releaseRoom(meeting.getLocation(), meeting.getInterval());
        meeting.getParticipants().forEach(user -> {
            user.removeMeetingFromCalender(meeting);
            if (!Objects.equals(meeting.getOrganizer().getEmail(), user.getEmail())) {
                new EmailNotification().sendCancelNotification(meeting.getOrganizer(), user, meeting);
            }
        });
    }

    public Optional<MeetingRoom> checkRoomsAvailability(int numberOfPersons, Interval interval) {
        return rooms.stream().filter((room) -> room.isAvailable(interval, numberOfPersons)).findAny();
    }

    private void releaseRoom(MeetingRoom meetingRoom, Interval interval) {
        meetingRoom.removeInterval(interval);
    }

    private void bookRoom(MeetingRoom meetingRoom, Interval interval) {
        meetingRoom.addInterval(interval);
    }

}
