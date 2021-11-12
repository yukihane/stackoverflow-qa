package com.example.so69905016;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc

public class SwStatusCheckTest {

    @Autowired
    private MockMvc mvc;

    @IfProfileValue(name = "spring.profiles.active", values = { "dev" })
    @Test
    @DisplayName("GET Method /SwCheckStatus check success")
    public void testStatusSuccess() throws Exception {

        MvcResult result = mvc.perform(get("/status/SwCheckStatus"))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
        //.andExpect(content().json("{\"services\":[\"OutboundMessageService\"]}", true));

        ObjectMapper mapper = new ObjectMapper();

        List<? extends Map<String, Object>> actualJson = mapper.readValue(result.getResponse().getContentAsString(),
            List.class);

        Map<String, Object> expected = Map.of("instanceName", "", "read", 1, "swProduct", "Area 1", "swProductModule",
            "Regular 1");

        boolean contains = false;
        for (Map<String, Object> a : actualJson) {
            boolean res = Maps.difference(a, expected).areEqual();
            if (res) {
                contains = true;
                break;
            }
        }
        assertThat(contains).isTrue();
    }
}
