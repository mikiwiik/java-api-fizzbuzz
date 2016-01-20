package pro.wiik.miki.fizzbuzz;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = Configurator.class)
public class RestApiTest {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void simpleSmokeTest() throws Exception {
        mockMvc.perform(get("/15"))
                .andExpect(status().isOk())
                .andExpect(content().string("FizzBuzz"));
    }

    @Test
    public void testLargeNumber() throws Exception {
        mockMvc.perform(get("/1234567890987654321"))
                .andExpect(status().isOk())
                .andExpect(content().string("Fizz"));
    }

    @Test
    public void negativeNumber() throws Exception {
        final Integer negativeNumber = -17;
        mockMvc.perform(get("/" + negativeNumber))
                .andExpect(status().isOk())
                .andExpect(content().string(negativeNumber.toString()));
    }
}
