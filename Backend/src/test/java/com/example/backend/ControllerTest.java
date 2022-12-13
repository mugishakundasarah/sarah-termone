package com.example.backend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MathOperatorImpl mathOperatorImpl;

    @Test
    public void it_should_return_value_after_Adding() throws Exception {
        when(mathOperatorImpl.doMath(2, 2, "+")).thenReturn(4.0);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/api/v1/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }
}
