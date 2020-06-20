package com.example.en62490937;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Slf4j
public class ParticipantController {

    @Autowired
    ParticipantServiceImpl participantService;

    @DeleteMapping(value = "/removeParticipantFromConference", consumes = "application/json")
    public String removeParticipantFromConference(@RequestBody @Valid Participant participant, @Valid Conference conference, BindingResult bindingResult) {
        log.info("Call for ParticipantController -> removeParticipantFromConference");
        log.info("Received message is {}, {}", participant, conference);

        if (bindingResult.hasErrors()) {
            log.error("bindingResult.hasErrors()");
            return "bindingResult.hasErrors()";
        }

        String resultMessage = participantService.removeParticipantFromConference(participant, conference);
        return resultMessage;
    }
}