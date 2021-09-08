package com.example.jaso82349;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class ExampleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void postEx1Test() throws Exception {

        mockMvc.perform(post("/")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/web/servlet/request/MockHttpServletRequestBuilder.html#content-java.lang.String-
            .content("fullName=%E3%83%86%E3%82%B9%E3%83%88%E5%A4%AA%E9%83%8E&age=20&ex1=")
            // あるいは param() を使って
            // .param("fullName", "テスト太郎")
            // .param("age", "20")
            // .param("ex1", "")
            )
            .andExpect(status().isOk())
            .andExpect(view().name("example.html"));

        //        
        //        ExampleFormEx1 form = new ExampleFormEx1();
        //        form.setFullName("テスト太郎");
        //        form.setAge(20);
        //        form.setEx1("");
        //        String requestForm = new ObjectMapper().writeValueAsString(form);
        //
        //        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
        //                .post("/")
        //                .content(requestForm)
        //                .accept("application/json;charset=UTF-8")
        //                .contentType("MediaType.APPLICATION_JSON");
        //        MvcResult result = mockMvc.perform(request)
        //                .andExpect(status().isOk())
        //                .andExpect(view().name("example.html"))
        //                .andReturn();

        // ...テスト処理...

    }

    @Test
    public void postEx2Test() throws Exception {
        ExampleFormEx2 form = new ExampleFormEx2();
        form.setFullName("テスト花子");
        form.setAge(30);
        form.setEx2("");
        String requestForm = new ObjectMapper().writeValueAsString(form);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
            .post("/")
            .content(requestForm)
            .accept("application/json;charset=UTF-8")
            .contentType("MediaType.APPLICATION_JSON");
        MvcResult result = mockMvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(view().name("example.html"))
            .andReturn();

        // ...テスト処理...

    }
}
