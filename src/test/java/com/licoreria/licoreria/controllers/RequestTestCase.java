package com.licoreria.licoreria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RequestTestCase {

    @Autowired
    private MockMvc mockMvc;

    public void assertResponse(String endPoint, Integer expectedStatusCode, String expectedResponse) throws Exception {
        ResultMatcher response = expectedResponse.isEmpty()
                ? content().string("")
                : content().json(expectedResponse);

        mockMvc.perform(MockMvcRequestBuilders.get(endPoint))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(response);
    }

    public void assertRequestWithBody(String method, String endPoint, String body, Integer expectedStatus) throws
            Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .request(HttpMethod.valueOf(method), endPoint)
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(expectedStatus))
                .andExpect(content().string(""));
    }

}
