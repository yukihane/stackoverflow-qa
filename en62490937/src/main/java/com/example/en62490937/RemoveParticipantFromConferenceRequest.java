package com.example.en62490937;

import javax.validation.Valid;
import lombok.Data;

@Data
public class RemoveParticipantFromConferenceRequest {
    @Valid
    private Participant participant;
    private Conference conference;
}
