package com.example.en62490937;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Slf4j
public class ConferenceController {

    @Autowired
    ConferenceServiceImpl conferenceService;

    @PostMapping(value = "/addConference", consumes = "application/json")
    public String addConference(@RequestBody @Valid Conference conference, BindingResult bindingResult) {
        log.info("Call for ConferenceController -> addConference. Received message is {}", conference);

        String resultMessage = conferenceService.addConference(conference);

        log.info("Sending response: " + resultMessage);
        return resultMessage;
    }
}