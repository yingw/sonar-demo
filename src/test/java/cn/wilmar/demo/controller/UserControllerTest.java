package cn.wilmar.demo.controller;

import cn.wilmar.demo.mapper.UserMapper;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    WebApplicationContext context;

    @Autowired
    UserController userController;

    @Autowired
    UserMapper userMapper;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getAllUsers() {
        try{
            mockMvc.perform(MockMvcRequestBuilders.post("/user/getAllUsers"))
                    .andExpect(status().isOk());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void saveUser() {
        try{
            Assert.assertNull(userMapper.selectByPrimaryKey(5L));
            Map<String,Object> map = new HashMap<>();
            map.put("id",5L);
            map.put("username","xxx");
            map.put("password","111111");
            map.put("role","");
            mockMvc.perform(MockMvcRequestBuilders.post("/user/addUser").content(JSONObject.toJSONString(map)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
            Assert.assertNotNull(userMapper.selectByPrimaryKey(5L));
            Assert.assertEquals("xxx",userController.getUserName(5L));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void updateUser() {
        try{
            Assert.assertNotNull(userMapper.selectByPrimaryKey(5L));
            Map<String,Object> map = new HashMap<>();
            map.put("id",5L);
            map.put("username","xxx111");
            map.put("password","111");
            map.put("role","");
            mockMvc.perform(MockMvcRequestBuilders.put("/user/updateUser").content(JSONObject.toJSONString(map)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
            Assert.assertThat(userController.getUserName(5L),is("xxx111"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getUserName() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/user/getUserName/3"))
                    .andExpect(status().isOk());
            Assert.assertEquals("Test3",userController.getUserName(3L));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteUser() {
        try{
            Assert.assertNotNull(userMapper.selectByPrimaryKey(5L));
            mockMvc.perform(MockMvcRequestBuilders.delete("/user/deleteUser/{id}",5L)).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
            Assert.assertNull(userMapper.selectByPrimaryKey(5L));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}