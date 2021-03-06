package cn.wilmar.demo.service;

import cn.wilmar.demo.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(@RequestBody User user);
    void updateUser(@RequestBody User user);
    String getUserName(@PathVariable("id") Long id);
    void deleteUser(@PathVariable("id") Long id);
}
