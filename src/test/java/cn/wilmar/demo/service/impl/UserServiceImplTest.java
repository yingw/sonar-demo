package cn.wilmar.demo.service.impl;

import cn.wilmar.demo.entity.Role;
import cn.wilmar.demo.entity.User;
import cn.wilmar.demo.mapper.UserMapper;
import cn.wilmar.demo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Test
    public void saveUser() {
        Assert.assertNull(userMapper.selectByPrimaryKey(4L));
        User user =new User();
        user.setId(4L);
        user.setPassword("111111");
        user.setUsername("mary");
        user.setGender("Male");
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId(2);
        role.setKey("user");
        role.setName("注册用户");
        roles.add(role);
        user.setRoles(roles);
        userService.saveUser(user);
        Assert.assertThat(userService.getUserName(4L),is("mary"));
    }

    @Test
    public void getAllUsers() {
        List<User> users = userService.getAllUsers();
        Assert.assertEquals("[User(id=1, username=yinguowei, password=111111, gender=Male, roles=null), User(id=2, username=yinxiaoqin, password=Yin Xiao Qin, gender=Female, roles=null), User(id=3, username=Test3, password=111111, gender=Male, roles=null), User(id=4, username=mary, password=111111, gender=Male, roles=null)]",users.toString());
    }

    @Test
    public void updateUser() {
        Assert.assertNotNull(userMapper.selectByPrimaryKey(4L));
        User user =userMapper.selectByPrimaryKey(4L);
        user.setUsername("kitty");
        userService.updateUser(user);
        Assert.assertThat(userService.getUserName(4L),is("kitty"));
    }

    @Test
    public void getUserName() {
        String name = userService.getUserName(3L);
        Assert.assertThat(name,is("Test3"));
    }


    @Test
    public void deleteUser() {
        Assert.assertNotNull(userMapper.selectByPrimaryKey(4L));
        userService.deleteUser(4L);
        Assert.assertNull(userMapper.selectByPrimaryKey(4L));
    }
}