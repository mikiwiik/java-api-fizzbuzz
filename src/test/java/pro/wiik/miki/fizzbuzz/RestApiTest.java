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

import static org.springframework.http.MediaType.TEXT_XML_VALUE;
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
    public void knownFizzBuzz() throws Exception {
        mockMvc.perform(get("/api/15"))
                .andExpect(status().isOk())
                .andExpect(content().string("FizzBuzz"));
    }

    @Test
    public void largeNumber() throws Exception {
        mockMvc.perform(get("/api/1234567890987654321"))
                .andExpect(status().isOk())
                .andExpect(content().string("Fizz"));
    }

    @Test
    public void negativeNumber() throws Exception {
        final Integer negativeNumber = -17;
        mockMvc.perform(get("/api/" + negativeNumber))
                .andExpect(status().isOk())
                .andExpect(content().string(negativeNumber.toString()));
    }

    @Test
    public void textXmlReturns406NotAcceptable() throws Exception {
        mockMvc.perform(get("/api/15").accept(TEXT_XML_VALUE))
                .andExpect(status().isNotAcceptable());
    }

    @Test
    public void nonNumberReturns400BadRequest() throws Exception {
        mockMvc.perform(get("/api/foo"))
                .andExpect(status().isBadRequest());
    }
}
