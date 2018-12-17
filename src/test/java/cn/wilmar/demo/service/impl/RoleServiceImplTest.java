package cn.wilmar.demo.service.impl;

import cn.wilmar.demo.entity.Role;
import cn.wilmar.demo.service.RoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceImplTest {

    @Autowired
    RoleService roleService;

    @Test
    public void getAll() {
        List<Role> roles = roleService.getAll();
        Assert.assertEquals("[Role(id=1, key=admin, name=管理员, description=null), Role(id=2, key=user, name=注册用户, description=null)]",roles.toString());
    }
}