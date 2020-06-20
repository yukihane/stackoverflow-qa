package com.example.en62490937;

import lombok.Data;

@Data
public class RemoveParticipantFromConferenceRequest {
    private Participant participant;
    private Conference conference;
}
