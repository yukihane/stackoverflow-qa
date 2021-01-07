package com.example.so65612634.controller;

import com.example.so65612634.So65612634Application;
import com.example.so65612634.model.dto.DtoUsernamePassword;
import com.example.so65612634.model.entity.EntityUser;
import com.example.so65612634.repository.RepositoryNote;
import com.example.so65612634.repository.RepositoryUser;
import com.example.so65612634.service.ServiceSign;
import com.example.so65612634.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ControllerSign.class)
//@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes= So65612634Application.class)
public class ControllerSignTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ServiceSign serviceSign;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private JwtUtil jwtUtil;
    
    @MockBean
    private RepositoryNote repositoryNote;
    @MockBean
    private RepositoryUser repositoryUser;

    @BeforeEach
    void printApplicationContext() {
        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .map(name -> applicationContext.getBean(name).getClass().getName())
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void createUser_valuesOK_statusOK() throws Exception {
        when(serviceSign.createUser(eq("user1"), eq("user1")))
                .thenReturn(jwtUtil.generateToken(new EntityUser("user1", "user1")));

        mockMvc.perform(
                post("/signup")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(new DtoUsernamePassword("user1", "user1")))
        ).andExpect(status().isOk());
    }


}
