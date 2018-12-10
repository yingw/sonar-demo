package cn.wilmar.demo.service.impl;

import cn.wilmar.demo.mapper.UserMapper;
import cn.wilmar.demo.model.User;
import cn.wilmar.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final String STRING = "用户不存在！";
    private static final String ERROR = "error";
    private static final String NETWORK_ERROR= "网络繁忙，请稍后再试！";
    @Override
    public List<User> getAllUsers() {
        List<User> users;
        users = userMapper.selectAll();
        return users;
    }

    @Override
    public String getUserName(@PathVariable("id") Long id) {
        try{
            User user = userMapper.selectByPrimaryKey(id);
            if (user == null){
                LOGGER.error(STRING);
                return STRING;
            }
            return user.getUsername();
        }catch (Exception e){
            LOGGER.error(ERROR,e);
            return NETWORK_ERROR;
        }

    }

    @Override
    public void saveUser(@RequestBody User user) {
        try {
            userMapper.insert(user);
        }catch (Exception e){
            LOGGER.error(ERROR,e);
        }
    }

    @Override
    public void updateUser(@RequestBody User user) {
        try {
            userMapper.updateByPrimaryKey(user);
        }catch (Exception e){
            LOGGER.error(ERROR,e);
        }
    }

    @Override
    public void deleteUser(@PathVariable("id") Long id) {
        try {
            User user = userMapper.selectByPrimaryKey(id);
            if (user != null){
                userMapper.deleteByPrimaryKey(id);
            }else {
               LOGGER.error(STRING);
            }
        }catch (Exception e){
            LOGGER.error(ERROR,e);
        }
    }
}