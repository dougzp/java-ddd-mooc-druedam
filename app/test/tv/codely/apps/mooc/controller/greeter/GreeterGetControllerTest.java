package tv.codely.apps.mooc.controller.greeter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import tv.codely.apps.Starter;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Starter.class)
@AutoConfigureMockMvc
class GreeterGetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void exposesGreeterEndpoint() throws Exception {
        mockMvc.perform(get("/greeter").param("name", "Daniel"))
            .andExpect(status().isOk())
            .andExpect(content().string("Hello Daniel!"));
    }

    @Test
    void greetsUnnamedUsersByDefault() throws Exception {
        mockMvc.perform(get("/greeter"))
            .andExpect(status().isOk())
            .andExpect(content().string("Hello unnamed!"));
    }

}
