package tv.codely.apps.mooc.controller.health_check;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import tv.codely.apps.Starter;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Starter.class)
@AutoConfigureMockMvc
final class ControllerExposureTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void exposesHealthCheckEndpoint() throws Exception {
        mockMvc.perform(get("/health-check"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status", is("ok")));
    }
}
