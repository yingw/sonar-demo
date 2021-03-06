package cn.wilmar.demo;

import cn.wilmar.demo.entity.Role;
import cn.wilmar.demo.entity.User;
import cn.wilmar.demo.service.UserService;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SonarDemoApplicationTests {

    @Autowired WebApplicationContext context;
    @Autowired SonarDemoApplication sonarDemoApplication;

    private MockMvc mockMvc;

    @Autowired
    private UserService userService;
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void hello() {
        try {
            Assert.assertEquals("Hello, World!", sonarDemoApplication.hello());
            mockMvc.perform(get("/")).andExpect(status().isOk());
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Test
    public void testMain() {
        SonarDemoApplication.main(new String[]{});
    }

}
