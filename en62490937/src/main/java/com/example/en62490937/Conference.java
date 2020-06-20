package com.example.en62490937;

import javax.validation.constraints.Max;
import lombok.Data;

@Data
public class Conference {
    @Max(2)
    private String name;
    private String startDateTime;
    private String endDateTime;
    private ConferenceRoom conferenceRoom;
}
