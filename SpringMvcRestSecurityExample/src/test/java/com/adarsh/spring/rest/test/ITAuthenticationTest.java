package com.adarsh.spring.rest.test;

/**
 * Created by Adarsh on 3/14/15.
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/configuration/applicationContext.xml"})
public class ITAuthenticationTest {

    @Autowired(required = true)
    protected WebApplicationContext webApplicationContext;

    @Autowired(required = true)
    private FilterChainProxy filterChainProxy;

    private MockMvc mockMvc;

    @Before
    public void setup() throws JsonProcessingException {
        this.mockMvc = webAppContextSetup(this.webApplicationContext).addFilter(filterChainProxy).build();
    }

    @Test
    public void loginByUsingIncorrectRequestMethod() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", "user")
                .param("password", "user")
        )
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }


    @Test
    public void loginWithCorrectCredentials() throws Exception {
        ResultActions resultActions=mockMvc.perform(MockMvcRequestBuilders.post("/api/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", "adarsh")
                .param("password", "adarsh")
        )
                .andExpect(MockMvcResultMatchers.status().isOk());
        MvcResult mvcResult=resultActions.andReturn();

    }
}
