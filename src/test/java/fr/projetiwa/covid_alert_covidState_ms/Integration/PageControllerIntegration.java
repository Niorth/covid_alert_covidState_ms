package fr.projetiwa.covid_alert_covidState_ms.Integration;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.sql.DataSource;

import java.security.Principal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PageControllerIntegration {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testStates() throws Exception {
        Principal mockPrincipal = Mockito.mock(Principal.class);
        this.mockMvc.perform(get("/personState/states")
                .principal(mockPrincipal))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
