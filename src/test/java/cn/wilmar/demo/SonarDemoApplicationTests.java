package cn.wilmar.demo;

import cn.wilmar.demo.web.UserController;
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
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
    public void getAllRoles() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/role/getAllRoles"))
                .andExpect(status().isOk());
    }

    @Test
    public void getUserName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/getUserName/4"))
				.andExpect(status().isOk());
    }

    @Test
    public void getAllUsers() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/user/getAllUsers"))
                .andExpect(status().isOk());
    }
    @Test
    public void saveUser() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("id",21L);
        map.put("username","xxx");
        map.put("password","111111");
        map.put("role","");
        mockMvc.perform(MockMvcRequestBuilders.post("/user/addUser").content(JSONObject.toJSONString(map)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void updateUser() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("id",4L);
        map.put("username","xxx111");
        map.put("password","111");
        map.put("role","");
        mockMvc.perform(MockMvcRequestBuilders.put("/user/updateUser").content(JSONObject.toJSONString(map)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void deleteUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/deleteUser/{id}",2L)).andExpect(status().isOk());
    }

    @Test
    public void testMain() {
        SonarDemoApplication.main(new String[]{});
    }

}
