package cn.wilmar.demo.service;

import cn.wilmar.demo.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    String getUserName(@PathVariable("id") Long id);
    void saveUser(@RequestBody User user);
    void updateUser(@RequestBody User user);
    void deleteUser(@PathVariable("id") Long id);
}
