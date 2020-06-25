package com.example.en62542331;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @Data
    public static class MyResource {
        private String text;
    }

    @GetMapping("/json")
    @ResponseBody
    public String indexRoute() {
        return "{\"text\": \"JSON HERE\"}";
    }

    @GetMapping("/jsp")
    public String indexJsp(final Model model) throws JsonMappingException, JsonProcessingException {
        final String jsonText = indexRoute();

        final ObjectMapper mapper = new ObjectMapper();
        final MyResource myResource = mapper.readValue(jsonText, MyResource.class);

        model.addAttribute("text", jsonText);
        model.addAttribute(myResource);

        return "index";
    }

}