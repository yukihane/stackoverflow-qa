package com.example.en62490937;

import lombok.Data;

@Data
public class Conference {
    private String name;
    private String startDateTime;
    private String endDateTime;
    private ConferenceRoom conferenceRoom;
}
