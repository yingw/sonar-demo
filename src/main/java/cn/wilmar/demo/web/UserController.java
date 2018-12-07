package cn.wilmar.demo.web;

import cn.wilmar.demo.mapper.UserMapper;
import cn.wilmar.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yin Guo Wei 2018/11/5.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @RequestMapping(value = "/getAllUsers",method = RequestMethod.POST)
    public List<User>getAllUsers() {
        try{
            List<User> users = new ArrayList<User>();
            users = userMapper.selectAll();
            if (users == null || users.isEmpty()){
                return new ArrayList<>();
            }
            return users;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }

    @RequestMapping(value = "/getUserName/{id}",method = RequestMethod.GET)
    public String getUserName(@PathVariable("id") Long id) {
        try{
            User user = userMapper.selectByPrimaryKey(id);
            if (user == null){
                return "用户不存在！";
            }
            return user.getUsername();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @PostMapping("/addUser")
    public void saveUser(@RequestBody User user) {
        try {
            userMapper.insert(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestBody User user) {
        try {
            userMapper.updateByPrimaryKey(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        try {
            User user = userMapper.selectByPrimaryKey(id);
            if (user != null){
                userMapper.deleteByPrimaryKey(id);
            }else {
                System.out.println("用户不存在！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
