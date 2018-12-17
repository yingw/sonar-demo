package cn.wilmar.demo.controller;

import cn.wilmar.demo.entity.User;
import cn.wilmar.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yin Guo Wei 2018/11/5.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/getAllUsers")
    public List<User>getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @GetMapping(value = "/getUserName/{id}")
    public String getUserName(@PathVariable("id") Long id) {
        return userService.getUserName(id);
    }


    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

}
