import model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MeetingSchedulerDriver {

    private static final Interval INTERVAL_1 = new Interval(
            LocalDateTime.of(2024, 1, 2, 1, 0, 0),
            LocalDateTime.of(2024, 1, 2, 2, 0, 0)
    );
    private static final Interval INTERVAL_2 = new Interval(
            LocalDateTime.of(2024, 1, 2, 3, 30, 0),
            LocalDateTime.of(2024, 1, 2, 4, 0, 0)
    );
    private static final Interval INTERVAL_3 = new Interval(
            LocalDateTime.of(2024, 1, 2, 5, 0, 0),
            LocalDateTime.of(2024, 1, 2, 7, 30, 0)
    );

    private static final Interval INTERVAL_4 = new Interval(
            LocalDateTime.of(2024, 1, 3, 7, 0, 0),
            LocalDateTime.of(2024, 1, 3, 8, 0, 0)
    );
    private static final Interval INTERVAL_5 = new Interval(
            LocalDateTime.of(2024, 1, 3, 9, 30, 0),
            LocalDateTime.of(2024, 1, 3, 10, 0, 0)
    );
    private static final Interval INTERVAL_6 = new Interval(
            LocalDateTime.of(2024, 1, 3, 5, 0, 0),
            LocalDateTime.of(2024, 1, 3, 6, 30, 0)
    );

    private static final MeetingRoom MEETING_ROOM_1 = new MeetingRoom("Room 1", 5);
    private static final MeetingRoom MEETING_ROOM_2 = new MeetingRoom("Room 2", 10);
    private static final MeetingRoom MEETING_ROOM_3 = new MeetingRoom("Room 3", 7);
    private static final MeetingRoom MEETING_ROOM_4 = new MeetingRoom("Room 4", 3);

    private static final User TUSHAR = new User("Tushar", "Tushar@gmail.com");
    private static final User VIKAS = new User("Vikas", "Vikas@gmail.com");
    private static final User AMAN = new User("Aman", "Aman@gmail.com");
    private static final User NAMAN = new User("Naman", "Naman@gmail.com");

    public static void main(String[] args) {
        System.out.println("Meeting scheduler");
        System.out.println("====================");

        List<MeetingRoom> meetingRooms = List.of(MEETING_ROOM_1,MEETING_ROOM_2,MEETING_ROOM_3,MEETING_ROOM_4);
        Notification notification = new EmailNotification();

        MeetingScheduler meetingScheduler = MeetingScheduler.getInstance(meetingRooms,notification);

        Optional<Meeting> meeting1 = createMeeting(meetingScheduler, INTERVAL_1, List.of(AMAN), AMAN,
                "LLD discussion", "Discussion about LLD.");
        if(meeting1.isPresent()){
            System.out.println(":: Meeting scheduled successfully "+meeting1.get());
        }else{
            System.out.println(":: Unable to schedule meeting.");
        }

        System.out.println("====================");


        Optional<Meeting> meeting2 = createMeeting(meetingScheduler, INTERVAL_1, List.of(AMAN, TUSHAR), AMAN,
                "LLD discussion 1", "Discussion about LLD 1.");

        if(meeting2.isPresent()){
            System.out.println(":: Meeting scheduled successfully "+meeting2.get());
        }else{
            System.out.println(":: Unable to schedule meeting.");
        }

        System.out.println("====================");

        Optional<Meeting> meeting3 = createMeeting(meetingScheduler, INTERVAL_1, List.of(AMAN, TUSHAR), AMAN,
                "LLD discussion 2", "Discussion about LLD 2.");
        if(meeting3.isPresent()){
            System.out.println(":: Meeting scheduled successfully "+meeting3.get());
        }else{
            System.out.println(":: Unable to schedule meeting.");
        }

        meeting2.ifPresent(meetingScheduler::cancelMeeting);

        System.out.println("====================");

        System.out.println(AMAN.getCalender());
    }

    private static Optional<Meeting> createMeeting(MeetingScheduler meetingScheduler, Interval interval,
                                                  List<User> participants, User organizer,
                                                  String title, String description) {
        return meetingScheduler.scheduleMeeting(interval, participants, organizer, title, description);
    }
}
