package cn.wilmar.demo.service.impl;

import cn.wilmar.demo.mapper.UserMapper;
import cn.wilmar.demo.entity.User;
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

    private static final String USER_NOT_EXIST = "用户不存在！";
    private static final String USER_EXIST = "用户已存在！";
    private static final String ERROR = "error";
    private static final String NETWORK_ERROR= "网络繁忙，请稍后再试！";
    private static final String ILLEGALA_PARAMETER = "无效的参数！";
    @Override
    public List<User> getAllUsers() {
        List<User> users;
        users = userMapper.selectAll();
        return users;
    }


    @Override
    public void saveUser(@RequestBody User user) {
        try {
            // 参数校验
            if (user == null) {
                LOGGER.error(ERROR,ILLEGALA_PARAMETER);
                return;
            }
            User u = userMapper.selectByPrimaryKey(user.getId());
            if (u != null){
                LOGGER.error(ERROR,USER_EXIST);
                return;
            }
            userMapper.insert(user);
        }catch (Exception e){
            LOGGER.error(ERROR,e);
        }
    }

    @Override
    public void updateUser(@RequestBody User user) {
        try {
            // 参数校验
            if (user == null) {
                LOGGER.error(ILLEGALA_PARAMETER);
                return;
            }
            User u = userMapper.selectByPrimaryKey(user.getId());
            if (u == null){
                LOGGER.error(USER_NOT_EXIST);
                return;
            }
            userMapper.updateByPrimaryKey(user);
        }catch (Exception e){
            LOGGER.error(ERROR,e);
        }
    }

    @Override
    public String getUserName(@PathVariable("id") Long id) {
        try{
            User user = userMapper.selectByPrimaryKey(id);
            if (user == null){
                LOGGER.error(USER_NOT_EXIST);
                return USER_NOT_EXIST;
            }
            return user.getUsername();
        }catch (Exception e){
            LOGGER.error(ERROR,e);
            return NETWORK_ERROR;
        }

    }

    @Override
    public void deleteUser(@PathVariable("id") Long id) {
        try {
            User user = userMapper.selectByPrimaryKey(id);
            if (user == null){
                LOGGER.error(USER_NOT_EXIST);
                return;
            }
            userMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            LOGGER.error(ERROR,e);
        }
    }
}
