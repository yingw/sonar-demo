package cn.wilmar.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SonarDemoApplicationTests {

    @Autowired WebApplicationContext context;
    @Autowired SonarDemoApplication sonarDemoApplication;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void hello() throws Exception {
        Assert.assertEquals("Hello, World!", sonarDemoApplication.hello());
        mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    public void testMain() {
        SonarDemoApplication.main(new String[]{});
    }

}
