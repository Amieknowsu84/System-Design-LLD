model.Meeting scheduler is an application where organiser can schedule a meeting in available meeting rooms and can add participants to join that
meeting at given timeframe and at a meetingRoom. System will send notification to all participants and organiser about meeting invite.
Participant can accept and reject meeting invitation. System will send notification to organiser if participant will reject/accept meeting invitation.
================================

Actor : Organiser, System, Participant(model.User)

Requirement : 
================================
1.) Organiser can schedule a meeting in a meetingRoom for a given timeframe, if meetingRoom is available during given timeframe.
2.) Participant can accept/reject meeting invitation.
3.) System will send notification about meeting invitation to organiser and all participants.
4.) System will send notification to organiser about reject/accept meeting.
5.) model.User can access to calendar about all meetings.
6.) There are n numbers of meeting rooms with specific capacity.
7.) model.MeetingRoom can be booked if available with in given timeframe.
8.) Organiser can cancel a meeting.